package com.bank.servlet;

import java.io.IOException;

import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.dto.TransactionID;
import com.bank.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Long acc=Long.parseLong(req.getParameter("acc"));
	double amt=Double.parseDouble(req.getParameter("amt"));
	if(acc!=null) {
		CustomerDAO cd=new CustomerDAOImp();
		Customer c=cd.getCustomer(acc);
		TransactionDAO td=new TransactionDAOImp();
		if(c.getName()!=null) {
			c.setBal(c.getBal()+amt);
			boolean res=cd.updateCustomer(c);
			 Transaction t=new Transaction(); 
			  
			 t.setTransactionId(TransactionID.generateTransactionId()); 
			   t.setUser(c.getAccno()); 
			   t.setRec_acc(c.getAccno()); 
			   t.setTransaction("CREDITED"); 
			   t.setAmount(amt); 
			   t.setBalance(c.getBal()); 
			   boolean res1=td.insertTransaction(t); 
			if(res && res1) {
			Customer c1=cd.getCustomer(acc);
			req.setAttribute("val",c1);
			RequestDispatcher rd=req.getRequestDispatcher("Deposit.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("key","failed to deposit");
			RequestDispatcher rd=req.getRequestDispatcher("Deposit.jsp");
			rd.forward(req, resp);
		}
			}else {
				req.setAttribute("key","Enter the correct Account number");
				RequestDispatcher rd=req.getRequestDispatcher("Deposit.jsp");
				rd.forward(req, resp);
			}
	}
}
}

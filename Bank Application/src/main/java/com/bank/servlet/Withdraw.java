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
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Long acc=Long.parseLong(req.getParameter("acc"));
	int pin=Integer.parseInt(req.getParameter("pin"));
	double amt=Double.parseDouble(req.getParameter("amt"));
	CustomerDAO cd=new CustomerDAOImp();
	Customer c=cd.getCustomer(acc);
	TransactionDAO td=new TransactionDAOImp();
	if(acc!=null && c.getPin()==pin) {
		
		if(c.getName()!=null ) {
			if(amt<c.getBal()) {
			c.setBal(c.getBal()-amt);
			boolean res=cd.updateCustomer(c);
			Transaction t=new Transaction(); 
			  
			 t.setTransactionId(TransactionID.generateTransactionId()); 
			   t.setUser(c.getAccno()); 
			   t.setRec_acc(c.getAccno()); 
			   t.setTransaction("DEBITED"); 
			   t.setAmount(amt); 
			   t.setBalance(c.getBal()); 
			   boolean res1=td.insertTransaction(t); 
			if(res && res1) {
			Customer c1=cd.getCustomer(acc);
			req.setAttribute("val",c1);
			RequestDispatcher rd=req.getRequestDispatcher("Withdraw.jsp");
			rd.forward(req, resp);
			}else {
				req.setAttribute("key","Insufficient Balance");
				RequestDispatcher rd=req.getRequestDispatcher("Withdraw.jsp");
				rd.forward(req, resp);
			}
		}else {
			req.setAttribute("key","failed to withdraw");
			RequestDispatcher rd=req.getRequestDispatcher("Withdraw.jsp");
			rd.forward(req, resp);
		}
			}else {
				req.setAttribute("key","Enter the correct Account number and pin");
				RequestDispatcher rd=req.getRequestDispatcher("Withdraw.jsp");
				rd.forward(req, resp);
			}
	}
}
}

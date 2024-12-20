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
@WebServlet("/Transferamount")
public class Transferamount extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Long facc=Long.parseLong(req.getParameter("facc"));
	Long tacc=Long.parseLong(req.getParameter("tacc"));
	int pin=Integer.parseInt(req.getParameter("pin"));
	double amt=Double.parseDouble(req.getParameter("amt"));
	CustomerDAO cd=new CustomerDAOImp();
	Customer c=cd.getCustomer(facc);
//	Customer c1=cd.getCustomer(tacc);
	TransactionDAO td=new TransactionDAOImp();
	if(facc!=null && c.getPin()==pin) {
		
		if(c.getName()!=null ) {
			if(amt<c.getBal()) {
			c.setBal(c.getBal()-amt);
			boolean res=cd.updateCustomer(c);
			Transaction ft=new Transaction(); 
			  
			   ft.setTransactionId(TransactionID.generateTransactionId()); 
			   ft.setUser(c.getAccno()); 
			   ft.setRec_acc(c.getAccno()); 
			   ft.setTransaction("DEBITED"); 
			   ft.setAmount(amt); 
			   ft.setBalance(c.getBal()); 
			   boolean res1=td.insertTransaction(ft); 
			if(res && res1) {
			Customer c1=cd.getCustomer(facc);
			req.setAttribute("val1",c1);
//			RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
//			rd.forward(req, resp);
			}else {
				req.setAttribute("key","Insufficient Balance");
				RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
				rd.forward(req, resp);
			}
		}else {
			req.setAttribute("key","failed to withdraw");
			RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
			rd.forward(req, resp);
		}
			}else {
				req.setAttribute("key","Enter the correct Account number and pin");
				RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
				rd.forward(req, resp);
			}
	}
	if(tacc!=null) {
		//CustomerDAO cd=new CustomerDAOImp();
		Customer c1=cd.getCustomer(tacc);
		//TransactionDAO td=new TransactionDAOImp();
		if(c1.getName()!=null) {
			c1.setBal(c1.getBal()+amt);
			boolean res=cd.updateCustomer(c1);
			 Transaction t=new Transaction(); 
			  
			 t.setTransactionId(TransactionID.generateTransactionId()); 
			   t.setUser(c1.getAccno()); 
			   t.setRec_acc(c1.getAccno()); 
			   t.setTransaction("CREDITED"); 
			   t.setAmount(amt); 
			   t.setBalance(c1.getBal()); 
			   boolean res1=td.insertTransaction(t); 
			if(res && res1) {
			Customer c2=cd.getCustomer(tacc);
			req.setAttribute("val2",c2);
			RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("key","failed to deposit");
			RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
			rd.forward(req, resp);
		}
			}else {
				req.setAttribute("key","Enter the correct  to Account number");
				RequestDispatcher rd=req.getRequestDispatcher("Transferamount.jsp");
				rd.forward(req, resp);
			}
	}
}
}

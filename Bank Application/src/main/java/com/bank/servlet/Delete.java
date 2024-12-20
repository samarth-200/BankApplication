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
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class Delete extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession sess=req.getSession(false);
	long acc=Long.parseLong(req.getParameter("acc"));
	Customer c=(Customer)sess.getAttribute("customer");
	CustomerDAO cd=new CustomerDAOImp();
	Customer c1=cd.getCustomer(acc);
	if(c.getAccno()!=c1.getAccno()) 
    { 
     double amount=c1.getBal(); 
     c.setBal(c.getBal()+c1.getBal()); 
     boolean res1=cd.updateCustomer(c); 
     if(res1) 
     {
    	 
     TransactionDAO td=new TransactionDAOImp();
      Transaction t1=new Transaction();    
      t1.setTransactionId(TransactionID.generateTransactionId()); 
      t1.setUser(c.getAccno()); 
      t1.setRec_acc(c1.getAccno()); 
      t1.setAmount(amount); 
      t1.setTransaction("CREDITED"); 
      t1.setBalance(c.getBal()); 
      boolean res=td.insertTransaction(t1); 
      if(res) 
      { 
      
        Boolean res2=cd.deleteCustomer(c1); 
        if(res2) {
        	req.setAttribute("key","Deleted successfully");
            RequestDispatcher rd=req.getRequestDispatcher("Getall.jsp");
            rd.forward(req, resp);
        }else {
        	req.setAttribute("key"," failed Deleted successfully");
            RequestDispatcher rd=req.getRequestDispatcher("Getall.jsp");
            rd.forward(req, resp);
        }
      } 
      else 
      { 
    	  req.setAttribute("key"," failed Deleted successfully");
          RequestDispatcher rd=req.getRequestDispatcher("Getall.jsp");
          rd.forward(req, resp); 
      } 
 
     } 
     else 
     { 
    	 req.setAttribute("key","Failed to delete; amount transfer failed from the customer account");
         RequestDispatcher rd=req.getRequestDispatcher("Getall.jsp");
         rd.forward(req, resp);
       
     } 
    } 
    else 
    { 

   	 req.setAttribute("key","Admin account can not be deleted");
        RequestDispatcher rd=req.getRequestDispatcher("Getall.jsp");
        rd.forward(req, resp);
}
}
}

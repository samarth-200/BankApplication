package com.bank.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.bank.dto.Customer;
import com.bank.dao.*;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
			//collect the data from user
		HttpSession session=req.getSession();
		Customer c=(Customer)session.getAttribute("customer");
			 long accno=Long.parseLong(req.getParameter("acc")); 
			String phonenumber=req.getParameter("phone"); 
			String mail=req.getParameter("mail"); 
			String name=req.getParameter("name"); 
			String pi=req.getParameter("pin"); 
			 int pin=Integer.parseInt(pi);
			//converting the necessary datatypes
			 long phone=Long.parseLong(phonenumber); 
			 
			//JDBC Implementation
			 //Student s=new Student();  
			CustomerDAO cd=new CustomerDAOImp(); 
			Customer c1=cd.getCustomer(accno);
			if(pin==c1.getPin()) 

			  { 
			   c.setAccno(accno);
			   c.setName(name); 
			   c.setPhone(phone); 
			   c.setMail(mail); 
			   
			   boolean result=cd.updateCustomer(c); 
			   if(result) 
			   { 
			    c=cd.getCustomer(accno); 
			    
			    //out.println("<h1>Data added successfully. Your Student ID is "+s.getId()+"</h1>"); 
			  req.setAttribute("key"," data updated successful");
			  RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			  rd.forward(req, resp);
			   } 
			   else 
			   { 
			    //out.println("<h1>Failed to add the data</h1>"); 
				   req.setAttribute("key","update failure");
				   RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				   rd.forward(req, resp);
			   } 
			  } else {
				  req.setAttribute("key","Enter correct pass word");
				   RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				   rd.forward(req, resp);
			  }
			 } 
			
}

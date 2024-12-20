package com.bank.servlet;

import java.io.IOException;
import com.bank.dao.*;
import com.bank.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Signup")
public class Signup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	Long phone=Long.parseLong(req.getParameter("phone"));
	String mail=req.getParameter("mail");
	int pass=Integer.parseInt(req.getParameter("password"));
	int con=Integer.parseInt(req.getParameter("confirm"));
	if(pass==con) {
		CustomerDAO cd=new CustomerDAOImp();
		Customer c=new Customer();
		c.setName(name);
		c.setPhone(phone);
		c.setMail(mail);
		c.setPin(con);
		boolean res=cd.insertCustomer(c);
		if(res) {
			req.setAttribute("key"," Account created successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("key","faled to ctreate account");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}
		
	}else {
		req.setAttribute("key","faled to ctreate account");
		RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
		rd.forward(req, resp);
	}
}
}

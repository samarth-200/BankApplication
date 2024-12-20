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
import jakarta.servlet.http.HttpSession;
@WebServlet("/Clogin")
public class Clogin extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	CustomerDAO cd=new CustomerDAOImp();
	String ac=req.getParameter("acc");
	String pass=req.getParameter("password");
	
	if(ac!=null) {
		long accc=Long.parseLong(ac);
		Customer c=new Customer();
		c=cd.getCustomer(accc, Integer.parseInt(pass));
		if(c.getMail()!=null) {
			session.setAttribute("customer", c);
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("key","Error");
			RequestDispatcher rd=req.getRequestDispatcher("Clogin");
			rd.forward(req, resp);
		}
	}else {
		req.setAttribute("key","Enter a correct crediantials");
		RequestDispatcher rd=req.getRequestDispatcher("Clogin");
		rd.forward(req, resp);
	}
}
}

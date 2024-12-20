package com.bank.servlet;

import java.io.IOException;

import com.bank.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Logout")
public class Logout extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	//Customer c=(Customer)session.getAttribute("customer");
	session.invalidate();
	req.setAttribute("key","Logout successfully");
	RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
	rd.forward(req, resp);
	
	
}
}

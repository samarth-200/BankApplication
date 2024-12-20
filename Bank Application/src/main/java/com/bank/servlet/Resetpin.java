package com.bank.servlet;
import java.io.IOException; 
import java.io.PrintWriter; 
import com.bank.dao.*; 
 
import com.bank.dto.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
@WebServlet("/Resetpin") 
public class Resetpin extends HttpServlet{ 
@Override 
protected void service(HttpServletRequest req, 
HttpServletResponse resp) throws ServletException, IOException { 
//collect the data from user
 

long acc=Long.parseLong(req.getParameter("acc")); 

int pin=Integer.parseInt(req.getParameter("pin")); 
int con=Integer.parseInt(req.getParameter("confirm")); 

 long phone=Long.parseLong(req.getParameter("phone")); 
PrintWriter out=resp.getWriter(); 
//JDBC Implementation
 Customer c=new Customer();  
CustomerDAO sdao=new CustomerDAOImp(); 
Customer c1=sdao.getCustomer(acc);
if(c1!=null && pin==con) 

  { 
   c1.setAccno(acc);
   c1.setPhone(phone); 
   
   c1.setPin(pin); 
   boolean result=sdao.updateCustomer(c1); 
   if(result) 
   { 
    c=sdao.getCustomer(acc); 
   // out.println("<h1>Password changed successfully. Your Student ID is "+s.getId()+"</h1>"); 
    req.setAttribute("key","PIN changed successfully");
    RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
    rd.forward(req, resp);
   }
   else 
   { 
	   req.setAttribute("key","failed to change PIN");
	    RequestDispatcher rd=req.getRequestDispatcher("Resetpin.jsp");
	    rd.forward(req, resp);
   } 
  }  
 } 
}
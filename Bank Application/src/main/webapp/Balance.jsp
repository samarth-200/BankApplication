<%@page import="com.bank.dao.*"%>
<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;
}
</style>
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">ABC Bank</h1>
		<h3 class="sub">Balance </h3>
		<% HttpSession sess=request.getSession(false);%>
 		
 		<%Customer c=(Customer)sess.getAttribute("customer");
 		CustomerDAO cd=new CustomerDAOImp();
 		Customer c1=cd.getCustomer(c.getAccno());
 		%>
		<h1 style="color:blue">NAME: <%=c.getName() %></h1>
		<h1 style="color:green">ACC NO: <%=c.getAccno() %></h1>
		<h1 style="color:red">BALANCE: <%=c1.getBal() %></h1>
		
	</div>
	<a href="Dashboard.jsp" ><button style="background-color:gold">DASHBOARD</button></a>
</body>
</html>
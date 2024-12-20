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
		<h1 class="heading">Student App</h1>
		<h3 class="sub">Application form</h3>
		<%String str=(String)request.getAttribute("key"); %>
		<%if(str!=null){ %>
		<h1 style="color:red"><%=str %></h1>
		<%} %>
		<%HttpSession sess=request.getSession(false); %>
		<%Customer s=(Customer)sess.getAttribute("customer"); %>
		<form action="Update" method="post">
			<table>
				<tr>
					<td><b>Enter your Account number:</b></td>
					<td><input type="number" name="acc" value="<%=s.getAccno()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter your Name:</b></td>
					<td><input type="text" name="name" value="<%=s.getName()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone" value="<%=s.getPhone()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail" value="<%=s.getMail()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><b>Enter the password:</b></td>
					<td><input type="password" name="pin"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="update account"></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>

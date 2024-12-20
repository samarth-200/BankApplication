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
		<h3 class="sub">Withdraw</h3>
		<%String key=(String)request.getAttribute("key") ;%>
		<%if(key!=null){ %>
		<h1 style="color:red"><%=key %></h1>
		<%} %>
		<form action="Withdraw">
			<table>
				
				<tr>
					<td><b>Enter the Account Number:</b></td>
					<td><input type="number" name="acc"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the PIN:</b></td>
					<td><input type="number" name="pin"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><b>Enter the Amount to deposit</b></td>
					<td><input type="number" name="amt"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Withdraw"></td>
					
					
				</tr>
				
			</table>
		</form>
		
	</div>
	<%Customer c1=(Customer)request.getAttribute("val") ;%>
		<%if(c1!=null){ %>
		<h1 style="color:red">Account Number <%=c1.getAccno()%></h1>
		<h1 style="color:red">Current Balance <%=c1.getBal()%></h1>
		<%} %>
		
		<a href="Dashboard.jsp"><button style="background-color:gold">DASHBOARD</button></a>
</body>
</html>
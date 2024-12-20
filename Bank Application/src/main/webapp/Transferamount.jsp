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
		<h3 class="sub">TRANSFER AMOUNT</h3>
		<%String key=(String)request.getAttribute("key") ;%>
		<%if(key!=null){ %>
		<h1 style="color:red"><%=key %></h1>
		<%} %>
		<form action="Transferamount">
			<table>
				
				<tr>
					<td><b>Enter the From Account Number :</b></td>
					<td><input type="number" name="facc"></td>
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
					<td><b>Enter the Amount </b></td>
					<td><input type="number" name="amt"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the To Account Number :</b></td>
					<td><input type="number" name="tacc"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>   
				</tr>
				
				<tr>
					<td><input type="submit" value="Transfer"></td>
					
					
				</tr>
				
			</table>
		</form>
		
	</div>
	<%Customer c=(Customer)request.getAttribute("val1") ;%>
		<%if(c!=null){ %>
		<h1 style="color:red">Account Number <%=c.getAccno()%></h1>
		<h1 style="color:red">Current Balance <%=c.getBal()%></h1>
		<%} %>
		<%Customer c1=(Customer)request.getAttribute("val2") ;%>
		<%if(c1!=null){ %>
		<h1 style="color:green">Account Number <%=c1.getAccno()%></h1>
		<h1 style="color:green">Current Balance <%=c1.getBal()%></h1>
		<%} %>
		
		<a href="Dashboard.jsp"><button style="background-color:gold">DASHBOARD</button></a>
</body>
</html>
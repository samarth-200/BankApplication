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
		<h3 class="sub"> AdminLogin form</h3>
		<%String key=(String)request.getAttribute("key") ;%>
		<%if(key!=null){ %>
		<h1 style="color:red"><%=key %></h1>
		<%} %>
		<form action="Alogin">
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
					<td><b>Enter the password:</b></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Login"></td>
					
					
				</tr>
				<tr>
					<td><a href="ResetPassword.html" >forgot password</a></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
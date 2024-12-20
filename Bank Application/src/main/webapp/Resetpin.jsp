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
		<h3 class="sub">Reset Pin</h3>
		<%String key=(String)request.getAttribute("key"); %>
		<%if(key!=null){ %>
		<%=key %>
		<%} %>
		<form action="Resetpin" method="post">
			<table>
			<tr>
					<td><b>Enter the Account number:</b></td>
					<td><input type="tel" name="acc"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the pin:</b></td>
					<td><input type="password" name="pin"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Confirm the pin:</b></td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="submit" value="reset"></td>
					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
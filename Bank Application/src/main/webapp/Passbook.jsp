<%@page import="java.util.List"%>
<%@page import="com.bank.dao.*"%>
<%@page import="com.bank.dto.*"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">ABC Bank</h1>
		<h3 class="sub">Passbook </h3>
		<% HttpSession sess=request.getSession(false);%>
        <%Customer c=(Customer)sess.getAttribute("customer"); %>
 		<%TransactionDAO td=new TransactionDAOImp();
 		List<Transaction> li=td.getTransaction(c.getAccno());
 		
 		%>
 		<table class="table table-hover">
 		<thead>
 		<tr>
 		<th>Transaction ID</th>
 		<th></th>
 		<th>Account Number</th>
 		<th></th>
 		<th>Transaction Date</th>
 		<th></th>
 		<th>Transaction type</th>
 		<th></th>
 		<th>Amount</th>
 		<th></th>
 		<th>Balance</th>
 		</tr>
 		
 		
 		</thead>
 		<tbody>
 		<% if(li!=null){for (Transaction s:li){%>
            <tr>
            <td><%=s.getTransactionId() %></td>
           <th></th>
            <td><%=s.getRec_acc() %></td>
            <th></th>
            <td><%=s.getDate() %></td>
            <th></th>
            <td><%=s.getTransaction() %></td>  
            <th></th>   
            <td><%=s.getAmount() %></td>
            <th></th>
            <td><%=s.getBalance() %></td>
            </tr>
            <%}} %>
 		</tbody>
 		</table>
 
		
	</div>
	<a href="Dashboard.jsp"><button style="background-color:gold">DASHBOARD</button></a>
</body>
</html>
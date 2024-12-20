<%@page import="com.bank.dao.*"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bank.dto.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial
scale=1.0"> 
<title>ABC Bank</title> 
<link 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet"> 
<style >
.del{
background-color:red;

}
</style>
</head> 
<body> 
 
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
<div class="container-fluid"> 
<a class="navbar-brand" href="#">Welcome Manager</a> 
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> 
        <span class="navbar-toggler-icon"></span> 
      </button> 
      <div class="collapse navbar-collapse" id="navbarNav"> 
        <ul class="navbar-nav ms-auto"> 
         <li class="nav-item"> 
            <a class="nav-link" href="Dashboard.jsp">My Account</a> 
          </li> 
          <li class="nav-item"> 
            <a class="nav-link" href="ResetPassword.jsp">Reset Pin</a> 
          </li> 
          <li class="nav-item"> 
            <a class="nav-link" href="Update.jsp">Update Data</a> 
          </li> 
          <li class="nav-item"> 
            <a class="btn btn-danger" href="Welcome.html">Logout</a> 
          </li> 
        </ul> 
      </div> 
    </div> 
  </nav> 
 
 

  <div class="container mt-4"> 
   <%String str=(String)request.getAttribute("delete"); %>
   <% if(str!=null){%>
  <h1 style="color:green"><%=str %></h1>
  <%} %>
  
    <h1 class="text-center mb-4">Dashboard</h1> 
</div> 
<!-- User Section --> 
    <div class="row"> 
      <div class="col-md-12"> 
        <h3>View Your Data</h3> 
        <table class="table table-hover"> 
          <thead> 
            <tr> 
              <th>Account number</th> 
              <th>Name</th> 
              <th>Phone</th> 
              <th>Mail ID</th> 
              <th>Balance</th> 
              <th>   </th>
            </tr> 
           <%CustomerDAO cd=new CustomerDAOImp();%>
            <%List<Customer> ss=cd.getCustomer(); %>
            <% if(ss!=null){for (Customer s:ss){%>
            <tr>
            <td><%=s.getAccno() %></td>
            <td><%=s.getName() %></td>
            <td><%=s.getPhone() %></td>
            <td><%=s.getMail() %></td>
            <td><%=s.getBal() %></td>
            
            <td>
<form action="delete">
<input type="hidden" name="acc" value="<%=s.getAccno() %>">
<button type="submit" class="del">Delete</button>
</form>
</td>
            </tr>
                        <%}}else{ %>
            <tr>
            <td colspan="6" class="text-center" >no data found</td>
            <%} %>
            </tr>
            
          </thead> 
          
          <tbody> 
          
         </tbody> 
        </table>
        
        <a href="AdminDashboard.jsp"><button>View only my data</button></a>
</div>
</div> 
</body> 
</html> 
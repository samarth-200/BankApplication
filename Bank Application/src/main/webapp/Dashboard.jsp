
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
<style type="text/css">
.disp{
display:flex;
}
.next{
margin-top:50px;
margin-left:200px
}
.butt{
height:60px;
width:150px;
margin:20px;
background:linear-gradient(to bottom,brown,gold);
}
</style>
</head> 
<body> 
<% HttpSession sess=request.getSession(false);%>
 <%Customer c=(Customer)sess.getAttribute("customer"); %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
<div class="container-fluid"> 
<a class="navbar-brand" href="#">Welcome <%=c.getName() %> </a> 
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> 
        <span class="navbar-toggler-icon"></span> 
      </button> 
      <div class="collapse navbar-collapse" id="navbarNav"> 
        <ul class="navbar-nav ms-auto"> 
          <li class="nav-item"> 
            <a class="nav-link" href="Resetpin.jsp">Reset Pin</a> 
          </li> 
          <li class="nav-item"> 
            <a class="nav-link" href="Update.jsp">Update Data</a> 
          </li> 
          <li class="nav-item"> 
           <form action="Logout">
            
            <input type="Submit" class="btn btn-danger" name="val" value="Logout"></input> 
          </form>
          </li> 
        </ul> 
      </div> 
    </div> 
  </nav> 
 
 

  <div class="container mt-4"> 
 <%String str=(String)request.getAttribute("key"); %>
  <%if(str!=null){ %>
  <h1 style="color:green"><%=str %></h1>
   <%} %>
  
  
  
    <h1 class="text-center mb-4">Dashboard</h1> 
</div> 

<!-- User Section --> 
<div class="disp">


    <div class="row" > 
      <div class="col-md-12"> 
        <h3>View Your Data</h3> 
        <table class="table table-hover" style="width:600px"> 
          <thead> 
            <% if(c!=null){%>
            <tr> 
              <th>Account Number</th> 
              <td><%=c.getAccno() %></td>
              
              </tr>
              <tr>
              <th>Name</th>
              <td><%=c.getName() %></td>
              </tr>
               <tr>
              <th>Phone</th> 
              <td><%=c.getPhone() %></td>
              </tr>
              <tr>
              <th>Mail ID</th> 
              <td><%=c.getMail() %></td>
              </tr>
              <tr>
              <th>Balance</th> 
          	  <td><%=c.getBal() %></td>
            </tr> 
            
                        <%}else{ %>
            <tr>
            <td colspan="6" class="text-center" >no data found</td>
            <%} %>
            </tr>
            
          </thead> 
          
          <tbody>
          
         </tbody> 
        </table>
        
        
</div>

</div> 
<div class="next" >
<table >
<tr>

<td><a href="Deposit.jsp" ><button class="butt">DEPOSIT</button></a></td>
<td><a href="Transferamount.jsp" ><button class="butt">TRANSFER AMOUNT</button></a></td>
</tr><tr>
<td><a href="Withdraw.jsp" ><button class="butt">WITHDRAW</button></a></td>
<td><a href="Passbook.jsp" ><button class="butt">PASS BOOK</button></a></td>
</tr><tr>
<td colspan="2" align="center"><a href="Balance.jsp" ><button class="butt">CHECK BALANCE</button></a></td>
</tr>
</table>
</div>
</div>

</body> 
</html> 
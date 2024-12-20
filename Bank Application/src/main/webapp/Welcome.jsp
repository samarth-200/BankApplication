<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank APP</title>
<style type="text/css">
body{
display:flux;
background:linear-gradient(to left,red,yellow);
}
.a{
margin-top:160px;
margin-left:500px;
margin-right:500px;
background-color:green;
border-radius:20px;

border:10px solid;
}
.butt{
height:50px;
width:100px;
background:linear-gradient(to bottom,gold,pink)
}
</style>
</head>
<body>
<%String str=(String)request.getAttribute("key"); %>
  <%if(str!=null){ %>
  <h1 style="color:green"><%=str %></h1>
   <%} %>
<div class="a" align="center">
<h1>Welcome to ABC Bank</h1>
<br>


<h2><a href="Alogin.jsp"><button class="butt" >Manager Login</button></a></h2>
<h2><a href="Clogin.jsp"><button class="butt">Customer Login</button></h2>
<h2><a href="Signup.jsp"><button class="butt">Create Account</button></a></h2>
</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
	Hey, Login with your credentials 
</h1>
<form:form id="loginForm" modelAttribute="user" action="loginuser.htm" method="POST">

<!--  <label>Username </label>
            <input type="text" name="username"><br>
           <label>Password </label>
           <input type="password" name="pwd"><br> -->
      <div class="form-group">     
             <label>Username</label>
   <form:input class="form-control" path="userName" name="userName" id="userName" type="text" required="true"/>
   <form:errors style="color:red" path="userName"/>
   </div>
   <div class="form-group">
   <label>Password</label>
   <form:input class="form-control" path="password" name="password" id="password" type="password" required="true"/>
   <form:errors style="color:red" path="password"/>
   </div>
   <div class="container text-center">
            <input class="btn btn-primary" type="submit" value="Login">  
            Not signed up yet ?
            <a href="register">Register</a>  
            </div>       
</form:form>
</div>
</div>
</div>
</body>
</html>
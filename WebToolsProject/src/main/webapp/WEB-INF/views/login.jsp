<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	Hey, Please login with your credentials 
</h1>
<form:form id="loginForm" modelAttribute="user" action="loginuser.htm" method="POST">

<!--  <label>Username </label>
            <input type="text" name="username"><br>
           <label>Password </label>
           <input type="password" name="pwd"><br> -->
           
             <label>Username</label>
   <form:input path="userName" name="userName" id="userName" type="text" />
   <form:errors path="userName"/><br>
   <label>Password</label>
   <form:input path="password" name="password" id="password" type="password" />
   <form:errors path="password"/><br>
            <input type="submit" value="Login ">  
            Not signed up yet ?
            <a href="register">Register</a>         
</form:form>
</body>
</html>
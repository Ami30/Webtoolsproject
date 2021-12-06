<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	We are so excited that you are joining us. Register to explore great properties 
</h1>
<form:form id="regForm" modelAttribute="user" action="saveuser.htm" method="POST">

   <label>First Name</label>
   <form:input path="fName" name="fName" id="fName" type="text" />
   <form:errors path="fName"/>
   <br>
   
   <label>Last Name</label>
   <form:input path="lName" name="lName" id="lName" type="text" />
   <form:errors path="lName"/><br>
   
   <label>Email Address</label>
   <form:input path="eMailID" name="eMailID" id="eMailID" type="text" />
   <form:errors path="eMailID"/><br>
   
   <label>Phone number</label>
   <form:input path="contact" name="contact" id="contact" type="text" />
   <form:errors path="contact"/><br>
   
   <label>Address</label>
   <form:input path="address" name="address" id="address" type="text" />
   <form:errors path="address"/><br>
   
   <label>Please select your role : </label>
   <form:radiobutton path="role" value="Buyer" />Buyer 
   <form:radiobutton path="role" value="Seller" />Seller
   <form:errors path="role"/>

 <!--            
            <input type="radio" name="role" value="Buyer">
			<label>Buyer</label>
			<input type="radio" name="role" value="Seller">
			<label>Seller</label><br>
             -->
   <label>Create Login credentials : </label><br>
   <label>Username</label>
   <form:input path="userName" name="userName" id="userName" type="text" />
   <form:errors path="userName"/>
   <label>Password</label>
   <form:input path="password" name="password" id="password" type="password" />
   <form:errors path="password"/><br>
   <input type="submit" value="Register">   
             Already registered ?
            <a href="login">Login</a>           
</form:form>
</body>
</html>
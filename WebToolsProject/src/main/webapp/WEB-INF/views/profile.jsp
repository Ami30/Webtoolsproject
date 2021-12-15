<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<style>	
.body-text {
margin-left: 200px;
font-size: 18px;
}
	</style>
</head>
<body>
<%@ include file ="navigation.jsp" %>

<div class="body-text">
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
	My Profile
</h1>
<form:form id="regForm" modelAttribute="user" action="saveuser.htm" method="POST">
 <form:input class="form-control" path="userId" name="userId" id="userId" type="hidden" value="${user.getUserId()}"/>
    <div class="form-group">  
   <label>First Name</label>
   <form:input class="form-control" path="fName" name="fName" id="fName" type="text" value="${user.getfName() }"/>
   <form:errors style="color:red" path="fName"/>
   </div>
    <div class="form-group">  
   <label>Last Name</label>
   <form:input class="form-control" path="lName" name="lName" id="lName" type="text" value="${user.getlName() }" />
   <form:errors style="color:red" path="lName"/>
   </div>
    <div class="form-group">  
   <label>Email Address</label>
   <form:input class="form-control" path="eMailID" name="eMailID" id="eMailID" type="text" value="${user.geteMailID()}" />
   <form:errors style="color:red" path="eMailID"/>
   </div>
    <div class="form-group">  
   <label>Phone number</label>
   <form:input class="form-control" path="contact" name="contact" id="contact" type="text" value="${user.getContact()}"/>
   <form:errors style="color:red" path="contact"/>
   </div>
    <div class="form-group">  
   <label>Address</label>
   <form:input class="form-control" path="address" name="address" id="address" type="text" value="${user.getAddress()}"/>
   <form:errors style="color:red" path="address"/>
   </div>

 <!--            
            <input type="radio" name="role" value="Buyer">
			<label>Buyer</label>
			<input type="radio" name="role" value="Seller">
			<label>Seller</label><br>
             -->
             
   <form:input class="form-control" path="role" name="role" id="role" type="hidden" value="${user.getRole()}" />
   <form:input class="form-control" path="userName" name="userName" id="userName" type="hidden" value="${user.getUserName()}" />

    <div class="form-group">  
   <label>Password</label>
   <form:input class="form-control" path="password" name="password" id="password" type="password" value="${user.getPassword()}" />
   <form:errors style="color:red" path="password"/>
   </div>

    <div class="container text-center">
   <input class="btn btn-primary" type="submit" value="Update">   
    </div>        
</form:form>
</div>
</div>
</div>
</div>


</body>
</html>
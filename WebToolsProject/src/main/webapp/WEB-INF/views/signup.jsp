<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Login</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
 <c:choose>
     <c:when test="${user1.getRole()=='Admin'}">
     <%@ include file ="navigationadmin.jsp" %>
     </c:when>
     </c:choose>
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
<c:choose>
     <c:when test="${user1.getRole()=='Admin'}">
     Add new User
     </c:when>
      <c:otherwise>
	We are so excited that you are joining us !
	  </c:otherwise>
	  </c:choose>
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form id="regForm" modelAttribute="user" method="POST">
    <div class="form-group">  
   <label>First Name</label>
   <form:input class="form-control" path="fName" name="fName" id="fName" type="text" />
   <form:errors style="color:red" path="fName"/>
   </div>
    <div class="form-group">  
   <label>Last Name</label>
   <form:input class="form-control" path="lName" name="lName" id="lName" type="text" />
   <form:errors style="color:red" path="lName"/>
   </div>
    <div class="form-group">  
   <label>Email Address</label>
   <form:input class="form-control" path="eMailID" name="eMailID" id="eMailID" type="text" />
   <form:errors style="color:red" path="eMailID"/>
   </div>
    <div class="form-group">  
   <label>Phone number</label>
   <form:input class="form-control" path="contact" name="contact" id="contact" type="text" />
   <form:errors style="color:red" path="contact"/>
   </div>
    <div class="form-group">  
   <label>Address</label>
   <form:input class="form-control" path="address" name="address" id="address" type="text" />
   <form:errors style="color:red" path="address"/>
   </div>
    <div class="form-group">  
    <c:choose>
     <c:when test="${user1.getRole()=='Admin'}">
   <label>Please select role : </label>
   <form:radiobutton path="role" value="Buyer" />Buyer 
   <form:radiobutton path="role" value="Seller" />Seller
   <form:radiobutton path="role" value="Admin" />Admin
   <br><form:errors style="color:red" path="role"/>
   </c:when>
   <c:otherwise>
   <label>Please select role : </label>
    <form:radiobutton path="role" value="Buyer" />Buyer 
   <form:radiobutton path="role" value="Seller" />Seller
   <br><form:errors style="color:red" path="role"/>
   </c:otherwise>
   </c:choose>
   </div>

 <!--            
            <input type="radio" name="role" value="Buyer">
			<label>Buyer</label>
			<input type="radio" name="role" value="Seller">
			<label>Seller</label><br>
             -->
    <div class="form-group">  
   <label><b>Create Login credentials : </b></label><br>
   <label>Username</label>
   <form:input class="form-control" path="userName" name="userName" id="userName" type="text" />
   <form:errors style="color:red" path="userName"/>
   </div>
    <div class="form-group">  
   <label>Password</label>
   <form:input class="form-control" path="password" name="password" id="password" type="password" />
   <form:errors style="color:red" path="password"/>
   </div>
     <div class="form-group">  
   <label>Confirm Password</label>
   <form:input class="form-control" path="confirmpassword" name="confirmpassword" id="confirmpassword" type="password" />
   <form:errors style="color:red" path="confirmpassword"/>
   </div>
  
    <c:choose>    
     <c:when test="${user1.getRole()=='Admin'}">
     <div class="container text-center">
     <input class="btn btn-primary" type="submit" value="Add user" formaction="${contextPath}/loginuser/adduser">  
     </div>
     </c:when> 
      <c:otherwise>
      <div class="container text-center">
   <input class="btn btn-primary" type="submit" value="Register" formaction="saveuser.htm">   
             Already registered ?
            <a href="login">Login</a> 
            </div>  
            </c:otherwise>
            </c:choose>
                  
</form:form>
</div>
</div>
</div>
</body>
</html>
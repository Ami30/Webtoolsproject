<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<style>	
	
.body-text {
margin-left: 200px;
font-size: 18px;
}
	</style>
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
		<script src="<c:url value="/resources/JS/test.js" />"></script>
</head>
<body>
<%@ include file ="navigationadmin.jsp" %>



<div class="body-text">

<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Users</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table class="table">
<thead class="thead-dark">
<tr>
<th scope="col">First Name</th>
<th scope="col">Last Name</th>
<th scope="col">Email Address</th>
<th scope="col">Contact Number</th>
<th scope="col">Address</th>
<th scope="col">Role</th>
<th scope="col">Action</th>
</tr>
</thead>
<tbody>

<c:forEach var="user" items="${userarray}">
<tr>
    <th>${user.getfName()}</th>
	<td>${user.getlName()}</td>
	<td>${user.geteMailID()}</td>
	<td>
     ${user.getContact()}  
	</td> 
	<td>${user.getAddress()}</td>
	<td>${user.getRole()}</td>
	<td> 
    <a href="${contextPath}/updateuser/${user.getUserId()}">Edit <i class="fas fa-pen-nib text-primary" style="font-size:20px;"></i></a> 
    </td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</div>


</body>
</html>
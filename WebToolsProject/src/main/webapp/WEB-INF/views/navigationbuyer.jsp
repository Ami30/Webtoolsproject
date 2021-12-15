<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<style>	
	.sidebar {
height: 100%;
width: 200px;
position: absolute;
left: 0;
top: 0;
padding-top: 40px;
background-color: #383c44;
font-color:white;
}

.sidebar div {
padding: 8px;
font-size: 20px;
display: block;
}

.body-text {
margin-left: 200px;
font-size: 18px;
}
.link 
{ 
text-decoration:none;
color: white; } 

.link:hover { 
color: red; 
} 
	</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div class="sidebar">
<c:set var="user" value ="${sessionScope.dbuser}"/>
<div style="color:red;">Hello ${user.getfName()}</div><br>
<div><a class="link" href="${contextPath}/loginuser/profile">My Profile</a></div>
<%-- <div><a href="${contextPath}/loginuser/newproperty" style="text-decoratsion:none;color:white">Add Property</a></div> --%>
<div><a class="link" href="${contextPath}/loginuser/browseproperties">Browse Properties</a></div>
<div><a class="link" href="${contextPath}/loginuser/searchproperties">Search Properties</a></div>
<div><a class="link" href="${contextPath}/logout">Logout</a></div>
</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>	
	.sidebar {
height: 100%;
width: 200px;
position: absolute;
left: 0;
top: 0;
padding-top: 40px;
background-color: lightblue;
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
	</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>

	Hello ${dbuser.getUserName()}

</h1>

 <div class="sidebar">
<%--  <c:out value="${sessionScope.dbuser.getUserName()}"></c:out> --%>

<div style="color:red;">Hello ${sessionScope.dbuser.firstName} <c:out value="${user.firstName}"/></div><br>
<div><a href="${contextPath}/loginuser/profile">My Profile</a></div>
<div><a href="${contextPath}/loginuser/newproperty">Add Property</a></div>
<div><a href="${contextPath}/loginuser/addedproperties">Added Properties</a></div>
<div><a href="${contextPath}/loginuser/soldproperties">Sold Properties</a></div>
</div>
 

<div class="body-text">
<h1>
	The property was successfully saved. Click <a href="/webtools/loginuser/newproperty" >here</a> to add more properties.
</h1>
</div>


</body>
</html>
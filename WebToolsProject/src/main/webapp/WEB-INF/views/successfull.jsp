<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<c:set var="user" value ="${sessionScope.dbuser}"/>
<c:choose>
              <c:when test="${user.getRole()=='Admin'}">
              	<%@ include file ="navigationadmin.jsp" %>
              	</c:when>
              	 <c:otherwise>
<%@ include file ="navigation.jsp" %>
</c:otherwise>
</c:choose>

<div class="body-text">
<div class="container mt-3">
<div class="row">
<div class="col-md-12">
<h1 class="text-center mb-3">Yay!! Updated successfully</h1>
</div>
</div>
</div>
</div>


</body>
</html>
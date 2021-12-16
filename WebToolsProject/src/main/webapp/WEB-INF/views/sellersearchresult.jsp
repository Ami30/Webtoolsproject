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
<h1 class="text-center mb-3">Here are your added Properties :</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table class="table">
<thead class="thead-dark">
<tr>
<th scope="col">Property Name</th>
<th scope="col">City</th>
<th scope="col">Price</th>
<th scope="col">Zip Code</th>
<th scope="col">Status</th>
<th scope="col">Action</th>
</tr>
</thead>
<tbody>

<c:forEach var="prop" items="${proparray}">
<tr>
   <th scope="row">${prop.getPropertyName()}</th>
	<td>${prop.getPropertyCity()}</td>
	<td class="font-weight-bold">&#x24; ${prop.getPropertyPrice()}</td>
	<td>${prop.getPropertyZipCode()}</td>
	<td>${prop.getAvailable()}</td>
	<td>
	<c:choose>
	 <c:when test="${user.getRole()=='Admin'}">
	  <a href="${contextPath}/view/${prop.getPropertyId()}">View<i class="fa fa-eye text-primary" style="font-size:20px;"></i></a> 
	  <a href="${contextPath}/update/${prop.getPropertyId()}">Edit <i class="fas fa-pen-nib text-primary" style="font-size:20px;"></i></a> 
	 </c:when>
     <c:otherwise>
         <a href="${contextPath}/view/${prop.getPropertyId()}">View<i class="fa fa-eye text-primary" style="font-size:20px;"></i></a>  
     </c:otherwise>
	</c:choose>

    </td>
    </tr>
</c:forEach>
</tbody>
</table>
<div class="container text-center">
<a href="${contextPath}/loginuser/searchproperties" class="btn btn-outline-secondary">Close</a>
</div>
</div>
</div>
</div>
</div>


</body>
</html>
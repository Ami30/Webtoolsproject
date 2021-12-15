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
<%@ include file ="navigationbuyer.jsp" %>

<div class="body-text">
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
	Property Details
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form id="quotePriceForm" modelAttribute="properties" action="${contextPath}/loginuser/browseprop/sendquotedamount" method="POST">
<form:input path="propertyId" name="propertyId" id="propertyId" type="hidden" value="${prop.getPropertyId()}"/>
<%-- <form:input path="propertyBuyerID" name="propertyBuyerID" id="propertyBuyerID" type="text" value="${prop.getPropertyId()}"/> --%>
   <div class="form-group">
   <label>Quoted Price</label>
   <form:input class="form-control" path="intrestedBuyerQuote" name="intrestedBuyerQuote" id="intrestedBuyerQuote" type="text"/>
   <form:errors path="intrestedBuyerQuote"/>
   </div>
   <div class="form-group">
   <label>Buyer Comments</label>
   <form:textarea class="form-control" path="propertyBuyercomments" name="propertyBuyercomments" id="propertyBuyercomments" type="text"/>
   <form:errors path="propertyBuyercomments"/>
   </div>
  <%--      <c:out value="${prop.getPropertySellercomments()}"/>
   <c:choose> --%>

  <%--   <c:when test="${prop.getPropertySellercomments()!=null}">	 --%>
   <div class="form-group">
   <label>Seller Comments</label>
   <form:textarea class="form-control" path="propertySellercomments" name="propertySellercomments" id="propertySellercomments" type="text" readonly="true"/>
   <form:errors path="propertySellercomments"/>
   </div>
 <%--   </c:when>
   </c:choose> --%>
         <div class="container text-center">
         <%-- <a href="${contextPath}/loginuser/buyerpropupdate"><button type="button" class="btn btn-primary">Close</button></a> --%>
   <input class="btn btn-primary" type="submit" value="Send Quoted Amount"> 
   </div>  
                      
</form:form>
</div>
</div>
</div>
</div>


</body>
</html>
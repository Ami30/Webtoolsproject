<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
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
	Update your Property
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form id="newPropForm" modelAttribute="properties" action="${contextPath}/loginuser/newproperty/saveproperty.htm" method="POST">
<form:input path="propertyId" name="propertyId" id="propertyId" type="hidden" value="${prop.getPropertyId()}"/>
   <div class="form-group">
   <label>Property Name</label>
   <form:input class="form-control" path="propertyName" name="propertyName" id="propertyName" type="text" value="${prop.getPropertyName()}"/>
   <form:errors path="propertyName"/>
   </div>
    <div class="form-group">
   <label>Property Address</label>
   <form:input class="form-control" path="propertyAddress" name="propertyAddress" id="propertyAddress" type="text" />
   <form:errors path="propertyAddress"/>
   </div>
    <div class="form-group">
   <label>Property City</label>
   <form:input class="form-control" path="propertyCity" name="propertyCity" id="propertyCity" type="text" />
   <form:errors path="propertyCity"/>
   </div>
    <div class="form-group">
   <label>Property Zip Code</label>
   <form:input class="form-control" path="propertyZipCode" name="propertyZipCode" id="propertyZipCode" type="text" />
   <form:errors path="propertyZipCode"/>
   </div>
    <div class="form-group">
   <label>Number of rooms</label>
    <form:input class="form-control" path="numrooms" name="numrooms" id="numrooms" type="text" />
   <form:errors path="numrooms"/>
   </div>
    <div class="form-group">
   <label>Number of Restrooms</label>
    <form:input class="form-control" path="numbathroom" name="numbathroom" id="numbathroom" type="text" />
   <form:errors path="numbathroom"/>
   </div>
    <div class="form-group">
      <label>Additional Details</label>
    <form:textarea class="form-control" path="propertyAdditionalDetails" name="propertyAdditionalDetails" id="propertyAdditionalDetails" type="text" />
   <form:errors path="propertyAdditionalDetails"/>
   </div>
    <div class="form-group">
      <label>Property Prices</label>
    <form:input class="form-control" path="propertyPrice" name="propertyPrice" id="propertyPrice" type="text" />
   <form:errors path="propertyPrice"/>
   </div>
    <div class="form-group">
   <label>Property Availability</label>
   <form:select class="form-control" path="available">  
    <form:option value="Available" label="Available"/>  
        <form:option value="InProgress" label="In Progress"/>  
         <form:option value="Sold" label="Sold"/>  
        </form:select> 
        </div>  
         <div class="container text-center">
   <input class="btn btn-primary" type="submit" value="Update Property"> 
   </div>  
                      
</form:form>
</div>
</div>
</div>
</div>


</body>
</html>
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
<form:form id="newPropForm" modelAttribute="properties" action="${contextPath}/loginuser/browseproperties">
<form:input path="propertyId" name="propertyId" id="propertyId" type="hidden" value="${prop.getPropertyId()}"/>
   <div class="form-group">
   <label>Property Name</label>
   <form:input class="form-control" path="propertyName" name="propertyName" id="propertyName" type="text" readonly="true"/>
   <form:errors path="propertyName"/>
   </div>
   <div class="form-group">
   <label>Seller Name</label>
   <form:input class="form-control" path="propertyOwner" name="propertyOwner" id="propertyOwner" type="text" readonly="true"/>
   <form:errors path="propertyOwner"/>
   </div>
    <div class="form-group">
   <label>Property Address</label>
   <form:input class="form-control" path="propertyAddress" name="propertyAddress" id="propertyAddress" type="text" readonly="true"/>
   <form:errors path="propertyAddress"/>
   </div>
    <div class="form-group">
   <label>Property City</label>
   <form:input class="form-control" path="propertyCity" name="propertyCity" id="propertyCity" type="text" readonly="true" />
   <form:errors path="propertyCity"/>
   </div>
    <div class="form-group">
   <label>Property Zip Code</label>
   <form:input class="form-control" path="propertyZipCode" name="propertyZipCode" id="propertyZipCode" type="text" readonly="true"/>
   <form:errors path="propertyZipCode"/>
   </div>
    <div class="form-group">
   <label>Number of rooms</label>
    <form:input class="form-control" path="numrooms" name="numrooms" id="numrooms" type="text" readonly="true"/>
   <form:errors path="numrooms"/>
   </div>
    <div class="form-group">
   <label>Number of Restrooms</label>
    <form:input class="form-control" path="numbathroom" name="numbathroom" id="numbathroom" type="text" readonly="true"/>
   <form:errors path="numbathroom"/>
   </div>
    <div class="form-group">
      <label>Additional Details</label>
    <form:textarea class="form-control" path="propertyAdditionalDetails" name="propertyAdditionalDetails" id="propertyAdditionalDetails" type="text" readonly="true"/>
   <form:errors path="propertyAdditionalDetails"/>
   </div>
    <div class="form-group">
      <label>Property Price (In $)</label>
    <form:input class="form-control" path="propertyPrice" name="propertyPrice" id="propertyPrice" type="text" readonly="true"/>
   <form:errors path="propertyPrice"/>
   </div>
    <div class="form-group">
   <label>Property Availability</label>
   <%-- <form:select class="form-control" path="available" readonly="true">  
    <form:option value="Available" label="Available" readonly="true" />  
        <form:option value="InProgress" label="In Progress" readonly="true"/>  
         <form:option value="Sold" label="Sold" readonly="true"/>  
        </form:select>  --%>
         <form:input class="form-control" path="available" name="available" id="available" type="text" readonly="true"/>
   <form:errors path="available"/>
        </div>  
         <div class="container text-center">
         <a href="${contextPath}/loginuser/browseproperties"><button type="button" class="btn btn-primary">Close</button></a>
  <!--  <input class="btn btn-primary" type="submit" value="Close">  -->
   </div>  
                      
</form:form>
</div>
</div>
</div>
</div>


</body>
</html>
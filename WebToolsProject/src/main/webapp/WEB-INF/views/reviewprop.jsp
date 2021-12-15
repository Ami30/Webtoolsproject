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
	Property Details
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form id="reviewPropForm" modelAttribute="properties" method="POST">
<form:input path="propertyId" name="propertyId" id="propertyId" type="hidden" value="${prop1.getPropertyId()}"/>
   <div class="form-group">
   <label>Property Name</label>
   <form:input class="form-control" path="propertyName" name="propertyName" id="propertyName" type="text" readonly="true" value="${prop1.getPropertyName()}"/>
   <form:errors path="propertyName"/>
   </div>
   <div class="form-group">
   <label>Buyer Name</label>
   <form:input class="form-control" path="propertyBuyerName" name="propertyBuyerName" id="propertyBuyerName" type="text" value="${prop1.getPropertyBuyerName()}" readonly="true"/>
   <form:errors path="propertyBuyerName"/>
   </div>
    <div class="form-group">
   <label>Property Address</label>
   <form:input class="form-control" path="propertyAddress" name="propertyAddress" id="propertyAddress" type="text" readonly="true" value="${prop1.getPropertyAddress()}"/>
   <form:errors path="propertyAddress"/>
   </div>
    <div class="form-group">
   <label>Property City</label>
   <form:input class="form-control" path="propertyCity" name="propertyCity" id="propertyCity" type="text" readonly="true" value="${prop1.getPropertyCity()}"/>
   <form:errors path="propertyCity"/>
   </div>
    <div class="form-group">
   <label>Property Zip Code</label>
   <form:input class="form-control" path="propertyZipCode" name="propertyZipCode" id="propertyZipCode" type="text" readonly="true" value="${prop1.getPropertyZipCode()}"/>
   <form:errors path="propertyZipCode"/>
   </div>
    <div class="form-group">
   <label>Number of rooms</label>
    <form:input class="form-control" path="numrooms" name="numrooms" id="numrooms" type="text" readonly="true" value="${prop1.getNumrooms()}"/>
   <form:errors path="numrooms"/>
   </div>
    <div class="form-group">
   <label>Number of Restrooms</label>
    <form:input class="form-control" path="numbathroom" name="numbathroom" id="numbathroom" type="text" readonly="true" value="${prop1.getNumbathroom()}"/>
   <form:errors path="numbathroom"/>
   </div>
    <div class="form-group">
      <label>Additional Details</label>
    <textarea class="form-control" name="propertyAdditionalDetails" id="propertyAdditionalDetails" readonly>${prop1.getPropertyAdditionalDetails()}</textarea>
 
   <form:errors path="propertyAdditionalDetails"/>
   </div>
    <div class="form-group">
      <label>Property Price (In $)</label>
    <form:input class="form-control" path="propertyPrice" name="propertyPrice" id="propertyPrice" type="text" readonly="true" value="${prop1.getPropertyPrice()}"/>
   <form:errors path="propertyPrice"/>
   </div>
    <div class="form-group">
   <label>Property Availability</label>
         <form:input class="form-control" path="available" name="available" id="available" type="text" readonly="true" value="${prop1.getAvailable()}"/>
   <form:errors path="available"/>
        </div>  
          <div class="form-group">
                        
   <label>Buyer Quoted Price</label>
         <form:input class="form-control" path="intrestedBuyerQuote" name="intrestedBuyerQuote" id="intrestedBuyerQuote" type="text" value="${prop1.getIntrestedBuyerQuote() }" readonly="true"/>
   <form:errors path="intrestedBuyerQuote"/>
        </div> 
         <div class="form-group">
   <label>Buyer Comments</label>
         <form:input class="form-control" path="propertyBuyercomments" name="propertyBuyercomments" id="propertyBuyercomments" type="text" value="${prop1.getPropertyBuyercomments()}" readonly="true"/>
   <form:errors path="propertyBuyercomments"/>
        </div> 
      <div class="form-group">
   <label>Seller Comments</label>
   <form:input class="form-control" path="propertySellercomments" name="propertySellercomments" id="propertySellercomments" type="text" value="${prop1.getPropertySellercomments()}" />
   <form:errors path="propertySellercomments"/>
   </div>
         <div class="container text-center">
     <c:choose>
    <c:when test="${prop1.getAvailable()!='Sold'}">	    
 <input class="btn btn-primary" type="submit" value="Save" formaction="${contextPath}/loginuser/savecomments"> 
 </c:when>
 </c:choose>
    <c:choose>
    <c:when test="${prop1.getAvailable()!='Sold'}">	   
   <input class="btn btn-success" type="submit" value="Approve" formaction="${contextPath}/loginuser/approveprice"> 
   </c:when>
   </c:choose>
   <c:choose>
    <c:when test="${prop1.getAvailable()!='Sold'}">
   <input class="btn btn-danger" type="submit" value="Reject" formaction="${contextPath}/loginuser/rejectprice"> 
   </c:when>
   </c:choose> 
   <%-- <a href="${contextPath}/loginuser/savecomments"><button type="button" class="btn btn-primary">Save</button></a>
   <a href="${contextPath}/loginuser/approveprice"><button type="button" class="btn btn-success">Approve</button></a>
     <a href="${contextPath}/loginuser/rejectprice"><button type="button" class="btn btn-danger">Reject</button></a> --%>
     <a href="${contextPath}/loginuser/addedproperties"><button type="button" class="btn btn-secondary">Close</button></a>
   </div>  
                      
</form:form>
</div>
</div>
</div>
</div>


</body>
</html>
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
<c:set var="user" value ="${sessionScope.dbuser}"/>
  <c:choose>
              <c:when test="${user.getRole()=='Admin'}">
              	<%@ include file ="navigationadmin.jsp" %>
              	</c:when>
              	
              <c:when test="${user.getRole()=='Buyer'}">
              	<%@ include file ="navigationbuyer.jsp" %>
              	</c:when>
              	
              	 <c:otherwise>
<%@ include file ="navigation.jsp" %>
</c:otherwise>
</c:choose>

<div class="body-text">
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
	Search Properties
</h1>
        <form action="submitsearchpropertiesseller.htm" method="POST">
        <div class="form-group">
            <label for="keyword">Keyword </label>
            <input class="form-control" type="text" name="keyword"><br>
            </div>           
             <div class="form-group">
            <input type="radio" name="searchproperty" value="available" required>    
            <label for="search_by_availability">Search by Availability Status</label>
            </div>
             <div class="form-group">
            <input type="radio" name="searchproperty" value="propertyCity">
            <label for="Search_by_Actor">Search by City</label>
            </div>
                <div class="form-group">
            <input type="radio" name="searchproperty" value="propertyZipCode">     
            <label for="Search_by_Actress">Search by ZipCode</label>
            </div>
                   <div class="form-group">
            <input type="radio" name="searchproperty" value="propertyOwner">     
            <label for="Search_by_Actress">Search by Seller Name</label>
            </div>
             <div class="container text-center">
             <c:set var="user" value ="${sessionScope.dbuser}"/>
             <c:choose>
              <c:when test="${user.getRole()=='Buyer'}">	
              <input class="btn btn-primary" type="submit" value="Search Properties" formaction="${contextPath}/loginuser/submitsearchpropertiesbuyer"> 
              </c:when>           
             <c:otherwise>
             <input class="btn btn-primary" type="submit" value="Search Properties" formaction="${contextPath}/loginuser/submitsearchpropertiesseller"> 
             </c:otherwise>
             </c:choose>
            
            </div>
        </form>
        </div>
        </div>
        </div>
        </div>
        
    </body>
</html>
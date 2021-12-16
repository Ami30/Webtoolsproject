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
<%@ include file ="navigationadmin.jsp" %>

<div class="body-text">
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">
	Search User
</h1>
        <form method="POST">
        <div class="form-group">
            <label for="keyword">Keyword </label>
            <input class="form-control" type="text" name="keyword"><br>
            </div>           
             <div class="form-group">
            <input type="radio" name="searchuser" value="role" required>    
            <label for="search_by_availability">Search by Role</label>
            </div>
             <div class="form-group">
            <input type="radio" name="searchuser" value="fName">
            <label for="Search_by_Actor">Search by First Name</label>
            </div>
                <div class="form-group">
            <input type="radio" name="searchuser" value="lName">     
            <label for="Search_by_Actress">Search by Last Name</label>
            </div>
             <div class="container text-center">
           
              <input class="btn btn-primary" type="submit" value="Search User" formaction="${contextPath}/loginuser/searchuserresult"> 
              <input class="btn btn-primary" type="submit" value="View all users" formaction="${contextPath}/loginuser/viewalluser">     
       
            </div>
        </form>
        </div>
        </div>
        </div>
        </div>
        
    </body>
</html>
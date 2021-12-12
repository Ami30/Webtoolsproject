<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%@ include file ="navigation.jsp" %>


<div class="body-text">
This is the sold properties
</div>


</body>
</html>
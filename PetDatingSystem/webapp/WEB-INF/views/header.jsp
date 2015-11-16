<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Dating System</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/styles/style.css" />
<script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>
<body>
	<header>		
		<a href="home">Home</a> |
		<a href="pets/all">View All Pets</a> | 
		<a href="pets">View My Pets</a> | 
		<a href="pets/add">Add New Pet</a> |		
		<a href="owner">My Profile</a> | 		
		Welcome 
		<strong>${sessionScope.ownerName}</strong>
		| <a href="logout">Log Out</a>
	</header>
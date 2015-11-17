<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Pet Dating System</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/styles/style.css" />
<script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>
<body>
	<div class="language">
		Language : <a
			href="${requestScope['javax.servlet.forward.request_uri']}?language=en">English</a>
		| <a
			href="${requestScope['javax.servlet.forward.request_uri']}?language=ne_NP">नेपाली</a>
	</div>

	<header>
		<a href="home"><spring:message code="home" text="Home" /></a> | <a
			href="pets/all"><spring:message code="view_all_pets"
				text="View All Pets" /></a> | <a href="pets"><spring:message
				code="view_my_pets" text="View My Pets" /></a> | <a href="pets/add"><spring:message
				code="add_new_pet" text="Add New Pet" /></a> | <a href="owner"><spring:message
				code="my_profile" text="My Profile" /></a> |
		<spring:message code="welcome" text="Welcome" />
		<strong>${sessionScope.ownerName}</strong> | <a href="logout"><spring:message
				code="logout" text="Log Out" /></a>
	</header>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Pet Dating System - Login Page</title>
<base href="${pageContext.request.contextPath}/" />
<meta charset="utf-8" />
<link rel="stylesheet" href="resources/styles/style.css" />
</head>
<body>
	<div class="language">
		Language : <a href="login?language=en">English</a> | <a
			href="login?language=ne_NP">नेपाली</a>
	</div>

	<div id="loginForm">
		<h1>
			<spring:message code="login" text="Login" />
		</h1>
		<form:form commandName="owner" action="" method="post">
			<div class="error">${loginError}</div>
			<table>
				<tr>
					<td><spring:message code="username" text="User Name" />:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td><spring:message code="password" text="Password" />:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="<spring:message code="submit" text="Submit" />" /></td>
				</tr>
			</table>
		</form:form>
		<div class="spacer">
			<a href="register"><spring:message code="new_user"
					text="New Owner? Register Here!" /></a>
		</div>
		<div class="spacer">
			<a href="rss"><spring:message code="rss" text="View RSS Feed" /></a>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
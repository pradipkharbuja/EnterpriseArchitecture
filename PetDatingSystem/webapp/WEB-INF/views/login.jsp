<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Dating System - Login Page</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/styles/style.css" />
</head>
<body>

	<div id="loginForm">
		<h1>Login for Pet Owners</h1>
		<form:form commandName="owner" action="" method="post">
		<div class="error">${loginError}</div>
			<table>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" value="pradip" /></td>					
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" value="kharbuja"/></td>					
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<div class="spacer"><a href="register">New Owner? Register Here!</a></div>
		<div class="spacer"><a href="rss">View RSS Feed</a></div>
	</div>

	<jsp:include page="footer.jsp" />
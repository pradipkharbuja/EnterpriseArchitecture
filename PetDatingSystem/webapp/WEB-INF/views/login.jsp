<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Dating System - Login Page</title>
<link rel="stylesheet" href="resources/styles/style.css" />
<base href="${pageContext.request.contextPath}/" />
</head>
<body>

	<div id="loginForm">
		<h1>Login for Pet Owners</h1>
		<form:form commandName="owner" action="" method="post">
		<div class="error">${loginError}</div>
			<table>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>					
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>					
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<jsp:include page="footer.jsp" />
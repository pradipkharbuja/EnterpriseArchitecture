<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Dating System - Registration Page</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/styles/style.css" />
</head>
<body>
	<div class="language">
		Language : <a href="register?language=en">English</a> | <a
			href="register?language=ne_NP">नेपाली</a>
	</div>
	
	<div id="registerForm">
		<h1>New Pet Owners</h1>
		<form:form commandName="owner" action="" method="post">
			<div class="error">
				<form:errors path="*" />
			</div>
			<table>
				<tr>
					<td>Full Name:</td>
					<td><form:input path="ownerName" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Instant Email:</td>
					<td><form:checkbox path="instantEmail" /></td>
				</tr>
				<tr>
					<td colspan="2">When other owner wants to contact you, if you
						check the Instant Email, you get email instantly otherwise you get
						at the end of the day.</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<div class="spacer">
			<a href="">Already Registered! Click Here to Login!</a>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<div id="registerForm">
	<h1>Update My Profile</h1>
	<form:form commandName="owner" action="" method="post">
		<div class="success">${successMsg}</div>
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
				<td><form:hidden path="password" /> <form:hidden
						path="userName" />${owner.userName }</td>
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
</div>

<jsp:include page="footer.jsp" />
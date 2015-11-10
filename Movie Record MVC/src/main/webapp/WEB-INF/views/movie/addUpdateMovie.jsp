<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add a Book</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css" />
</head>
<body>
	<form:form commandName="movie" action="" method="post">
		<table>
			<tr>
				<td>Movie Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Year:</td>
				<td><form:input path="year" /></td>
				<td><form:errors path="year" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:input path="rating" /></td>
				<td><form:errors path="rating" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Summary:</td>
				<td><textarea rows="3" cols="20" name="summary"></textarea></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td colspan="2"><form:checkboxes items="${genresList}" path="genres" /> </td>				
			</tr>
			<tr>
				<td>Directors:</td>
				<td colspan="2"><form:checkboxes items="${directorsList}" path="directors" /> </td>				
			</tr>
			<tr>
				<td>Artists:</td>
				<td colspan="2"><form:checkboxes items="${artistsList}" path="artists" /> </td>				
			</tr>
		</table>
		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>
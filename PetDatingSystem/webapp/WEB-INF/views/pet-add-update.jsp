<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<div id="registerForm">
	<h1>Add / Update My Pet</h1>
	<form:form commandName="pet" action="" method="post">
		<div class="success">${successMsg}</div>
		<div class="error">
			<form:errors path="*" />
		</div>
		<table>
			<tr>
				<td>Select Pet Type:</td>
				<td><select id="petType" name="petType">
						<c:forEach var="petType" items="${petTypes}">
							<option value="${petType.petTypeId}">${petType.petType}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select Breed:</td>
				<td><select id="breed" name="breed">
						<c:forEach var="breed" items="${breeds}">
							<option value="${breed.breedId}" rel="${breed.petType.petTypeId}">${breed.breedName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Pet Name:</td>
				<td><form:input path="petName" /></td>
			</tr>
			<tr>
				<td>Upload a Photo:</td>
				<td><input type="file" name="petPhoto">
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</div>

<jsp:include page="footer.jsp" />
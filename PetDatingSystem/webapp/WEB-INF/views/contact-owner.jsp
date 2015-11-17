<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div id="contact-owner">
	<div class="animal">
		<h1>
			<a href="pet/${pet.petId}">${pet.petName}</a>
		</h1>
		<img class="animal-image" src="image/${pet.petId}">
		<div class="city">Animal Type : ${pet.breed.petType.petType}</div>
		<div class="city">Breed : ${pet.breed.breedName}</div>
		<div class="owner">Owner Name: ${pet.owner.ownerName}</div>
		<div class="city">City : ${pet.owner.city}</div>
	</div>

	<div class="email-form">
		<div class="success">${successMsg}</div>
		<form method="post" action="">
			<table>
				<tr>
					<td>Receiver:</td>
					<td>${pet.owner.ownerName}</td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input class="subject" type="text" required="required"
						name="subject" /></td>
				</tr>
				<tr>
					<td valign="top">Message:</td>
					<td><textarea name="message" required="required"
							class="message"></textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Send Email" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<jsp:include page="footer.jsp" />

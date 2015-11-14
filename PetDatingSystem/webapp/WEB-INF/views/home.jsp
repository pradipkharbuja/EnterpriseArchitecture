<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div id="animal-list">
	<c:forEach items="${listPets}" var="pet">
		<div class="animal">
			<form method="post" action="">
				<input type="hidden" name="petId" value="${pet.petId}">
				<h1>
					<a href="pet/${pet.petId}">${pet.petName}</a>
				</h1>
				<img class="animal-image"
					src="resources/images/image-unavailable.jpg">
				<div class="city">Animal Type : ${pet.breed.petType.petType}</div>
				<div class="city">Breed : ${pet.breed.breedName}</div>
				<div class="city">City : ${pet.owner.city}</div>
				<button class="btn-contact" type="submit">Contact Owner</button>
			</form>
		</div>
	</c:forEach>
</div>

<jsp:include page="footer.jsp" />

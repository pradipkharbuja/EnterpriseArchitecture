<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div id="animal-list">
	<c:forEach items="${getAllPets}" var="pet">
		<div class="animal">
			<h1>
				<a href="pets/details/${pet.petId}">${pet.petName}</a>
			</h1>
			<img class="animal-image" src="image/${pet.petId}">
			<div class="city">Animal Type : ${pet.breed.petType.petType}</div>
			<div class="city">Breed : ${pet.breed.breedName}</div>
			<div class="city">City : ${pet.owner.city}</div>
			<c:if test="${pet.owner.ownerId != sessionScope.ownerId}">
				<a href="owner/contact/${pet.petId}">Contact Owner</a>
			</c:if>
			<c:if test="${pet.owner.ownerId == sessionScope.ownerId}">
				<a href="pets/update/${pet.petId}">Update</a> &nbsp;
					<a onClick="return confirm('Are you sure to delete?')"
					href="pets/delete/${pet.petId}">Delete</a>
			</c:if>
		</div>
	</c:forEach>
</div>

<jsp:include page="footer.jsp" />

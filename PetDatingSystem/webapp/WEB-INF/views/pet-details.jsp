<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div id="pet-details">
	<div class="animal">
		<h1>
			<a href="pets/details/${pet.petId}">${pet.petName}</a>
		</h1>
		<img class="animal-image" src="image/${pet.petId}">
		<div class="city">Animal Type : ${pet.breed.petType.petType}</div>
		<div class="city">Breed : ${pet.breed.breedName}</div>
		<div class="owner">Owner Name: ${pet.owner.ownerName}</div>
		<div class="city">City : ${pet.owner.city}</div>
	</div>

	<div class="comment-form">
		<div id="comment-lists">
			<c:forEach items="${comments}" var="comment">
				<div class="comment-row">
					<div class="user">${comment.owner.ownerName}&nbsp;says on
						${comment.commentDate} :</div>
					<div class="comment">${comment.comments}</div>
				</div>
			</c:forEach>
		</div>
		<form method="post" action="">
			<table>
				<tr>
					<td><textarea name="comments" required="required"
							class="comments" placeholder="Write your comment..."></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="Post Comment" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<jsp:include page="footer.jsp" />

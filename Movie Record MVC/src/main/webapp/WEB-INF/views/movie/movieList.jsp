<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies List</title>
</head>
<body>
	<h1>Movies List</h1>
	<table>
		<tr>
			<th>Movie Name</th>
			<th>Year</th>
			<th>Rating</th>			
			<th>Directors</th>
			<th>Artists</th>
			<th>Genre</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td>${movie.rating}</td>
				<td>${movie.rating}</td>
				<td>${movie.rating}</td>
				<td>${movie.rating}</td>
				<td><a href="movies/update/${movie.movieId}">edit</a></td>
				<td><a onClick="return confirm('Are you sure to delete?');"
					href="movies/delete/${movie.movieId}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="movies/add"> Add a movie</a>
</body>
</html>
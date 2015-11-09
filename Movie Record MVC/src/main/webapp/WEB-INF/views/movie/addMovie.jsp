<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Add a Book</title>
</head>
<body>
	<form action="add" method="post">
	<table>
		<tr>
			<td>Movie Name:</td>
			<td><input type="text" name="name" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="year" /> </td>
		</tr>
		<tr>
			<td>Rating:</td>
			<td><input type="text" name="rating" /> </td>
		</tr>
		<tr>
			<td>Summary:</td>
			<td><textarea rows="3" cols="20" name="summary"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="Submit"/>
	
	</form>
</body>
</html>
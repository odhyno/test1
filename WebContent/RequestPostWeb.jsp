<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<h1>REQUEST POSTS</h1>
	<input type="submit" name="action" value="message">
	<input type="submit" name="action" value="profile">
	<input type="submit" name="action" value="logout">

	<form method=post action="RequestPostWeb">
		<table>
			<tr>
				<td><textarea rows="4" cols="50" name="comment" form="usrform">${requestpost}</textarea></td>
			</tr>
		</table>

		<input type="submit" name="action" value="NewPost"> 
		<input type="submit" name="action" value="SearchPost"> 
		<input type="submit" name="action" value="ManagePost"> 
			<table>
			<tr>
				<td><input type="submit" name="action" value="back"></td>
			</tr>
		</table>
	</form>
</body>
</html>
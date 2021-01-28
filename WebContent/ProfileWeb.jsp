<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<h1>YOUR PROFILE</h1>
	<input type="submit" name="action" value="message">
	<input type="submit" name="action" value="profile">
	<input type="submit" name="action" value="logout">

	<form method=post action="ProfileWeb">
		<table>
			<tr>
				<td><textarea rows="4" cols="50" name="comment" form="usrform">${profile}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="ModifyProfile"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="ModifyData"></td>
			</tr>
		</table>

	</form>
</body>
</html>
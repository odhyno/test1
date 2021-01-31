<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<h1>MODIFY PROFILE</h1>
	<h1>Only inserted fields will be removed</h1>
	<form method=post action="ModifyProfileWeb">
		<input type="submit" name="action" value="message">
		<input type="submit" name="action" value="profile">
		<input type="submit" name="action" value="logout">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" name="lastname"></td>
			</tr>
			<tr>
                <td>BirthDate</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"></td>
				<td><input type="submit" name="action" value="back"></td>
			</tr>
		</table>
	</form>
</body>
</html>
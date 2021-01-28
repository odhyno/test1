<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<h1>NEW REQUEST POST</h1>
	<input type="submit" name="action" value="message">
	<input type="submit" name="action" value="profile">
	<input type="submit" name="action" value="logout">

	<form method=post action="NewRequestPostWeb">
		<table>
			<tr>
				<td>Title</td>
			</tr>
			<tr>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Description</td>
			</tr>
			<tr>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="insert"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="back"></td>
			</tr>
		</table>

	</form>

</body>
</html>
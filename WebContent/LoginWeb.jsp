<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<h1>SOCIAL MUSIC</h1>
	<form method = post action="LoginWeb">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name = "action" value="login"></td>
			</tr>
			<tr>
			    <td></td>
				<td><input type="submit" name = "action" value="register"></td>
			</tr>
			<tr>
			    <td></td>
				<td><input type="submit" name = "action" value="recovery"></td>
			</tr>
			<tr>
			    <td></td>
				<td><input type="submit" name = "action" value="google login"></td>
			</tr>
		</table>

	</form>

</body>
</html>
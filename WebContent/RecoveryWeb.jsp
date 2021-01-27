<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
    <h1>RECOVERY DATA</h1>
	<form method = post action="RecoveryWeb">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
			    <td></td>
				<td><input type="submit" name = "action" value="recovery"></td>
			</tr>
		</table>

	</form>
</body>
</html>
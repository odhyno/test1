<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>MODIFY DATA</h1>
	<h1>Only inserted fields will be removed</h1>
	<form method=post action="ModifyProfileWeb">
				<input type="submit" name="action" value="message">
				<input type="submit" name="action" value="profile">
				<input type="submit" name="action" value="logout">
			
		<table>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"></td>
				<td><input type="submit" name="action" value="back"></td>
			</tr>
		</table>
	</form>
</body>
</html>
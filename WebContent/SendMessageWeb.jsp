<%@ page import="logic.control.ControlSendMessage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>
	<form method=post action="SendMessageWeb">
		Choose user: <input type="text" name="username"> <input
			type="submit">
	</form>
	<br>
	<h1>List Of Users:</h1>
	<textarea rows="4" cols="50" name="comment" form="usrform">${users}</textarea>
</body>
</html>
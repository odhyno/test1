<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>

	CHAT WITH ${receiver}
	<textarea rows="4" cols="50" name="comment" form="usrform">${messages}</textarea>
	<form method=post action="ChatWeb">
		Send Message: <input type="text" name="message"> <input
			type="submit">
	</form>
</body>
</html>
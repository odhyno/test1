<%@ page import="boundary.WindowManager"%>
<%@ page import ="logic.RequestScene"%>
<%@ page import ="logic.Main"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>WELCOME</h1>
	<form method=post action="HomePageWeb">
		<table>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="sample post"></td>
				<td></td>
				<td><input type="submit" name="action" value="band/member post"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="topic post"></td>
				<td></td>
				<td><input type="submit" name="action" value="ranking"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="view rules"></td>
				<td></td>
				<td><input type="submit" name="action" value="messages"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="profile"></td>
				<td></td>
				<td><input type="submit" name="action" value="logout"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="action"  id="doreport" value="do report"></td>
				<td></td>
				<td><input type="submit" name="action"  id="readrules" value="read rules"></td>
			</tr>


		</table>

	</form>

	
</body>


</html>
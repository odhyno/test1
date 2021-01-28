<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>

<script type="text/javascript">
	function mod() {

		document.getElementById("Remove").style.visibility = 'hidden';
		document.getElementById("id").style.visibility = 'visible';
		document.getElementById("okmod").style.visibility = 'visible';
		document.getElementById("title").style.visibility = 'visible';
		document.getElementById("description").style.visibility = 'visible';
	}
</script>

<script type="text/javascript">
	function rem() {

		document.getElementById("Modify").style.visibility = 'hidden';
		document.getElementById("id").style.visibility = 'visible';
		document.getElementById("okrem").style.visibility = 'visible';

	}
</script>

<body>
	<h1>MANAGE REQUEST POSTS</h1>
	<input type="submit" name="action" value="message">
	<input type="submit" name="action" value="profile">
	<input type="submit" name="action" value="logout">
	<table>
		<tr>
			<td><textarea rows="4" cols="50" name="comment" form="usrform">${requestmypost}</textarea></td>
		</tr>
	</table>
	<input type="submit" name="action" id="Modify" value="ModifyPost"
		onclick="mod()">
	<input type="submit" name="action" id="Remove" value="RemovePost"
		onclick="rem()">
	<input type="submit" name="action" value="back">

	<form method=post action="ManageRequestPostWeb">
		<table>
			<tr>
				<td><input type="text" id="id" name="text"
					placeholder="insert # id" style="visibility: hidden;"></td>
			</tr>
			<tr>
				<td><input type="text" id="title" name="title"
					placeholder="new title" style="visibility: hidden;"></td>
			</tr>
			<tr>
				<td><input type="text" id="description" name="description"
					placeholder="new description" style="visibility: hidden;"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" id="okmod"
					value="Modify" style="visibility: hidden;"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" id="okrem"
					value="Remove" style="visibility: hidden;"></td>
			</tr>
		</table>
	</form>
</body>
</html>
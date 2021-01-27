<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Music</title>
</head>
<body>

	WELCOME ${credentials}
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
				<td><input type="submit" name="action" id="managerules"
					value="manage rules"></td>
				<td></td>
				<td><input type="submit" name="action" id="managereport"
					value="manage report"></td>
				<td></td>
				<td><input type="submit" name="action" id="manageusers"
					value="manage users"></td>
			</tr>


		</table>

		<script>
   		 document.getElementById("benvenuto").value="WELCOME" +  (String) session.getAttribute("credentials">;
	</script>

	</form>

</body>


</html>
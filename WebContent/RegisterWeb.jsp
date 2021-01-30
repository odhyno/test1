<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOCIAL MUSIC</title>

<script type="text/javascript">
    
        function showHide()
        {
            if(document.getElementById('Checkbox1').checked)
            {
                document.getElementById('Text1').style.visibility = 'visible';
            }
            else
            {
                document.getElementById('Text1').style.visibility = 'hidden';
            }
        }

    </script>
</head>
<body>
	<h1>REGISTER</h1>
	<form method=post action="RegisterWeb">
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
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
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
				<td><input type="date" name="birthdate"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="register"></td>
			</tr>

		</table>

	</form>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
Age is: ${age}
<body>


	<form action="LoginServlet" method="post">
		<input type="hidden" name="action" value="login">
		
		<label>Name:</label>
		<input type="text" name="name" required><br/>
		
		<label>Password:</label>
		<input type="password" name="password" required><br/>
		
		<label>&nbsp;</label>
		<input type="submit" value="Login" id="submit">
	</form>
	
</body>
</html>
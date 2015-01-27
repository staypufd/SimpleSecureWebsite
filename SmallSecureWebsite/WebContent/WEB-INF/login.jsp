<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<title>Login</title>
</head>

<body>
	<c:import url="/header.jsp">
		<c:param name="isLoggedIn" value="false"/>
	</c:import>

	<p>Age is: ${age}</p>

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
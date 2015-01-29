
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<c:import url="/header.html"></c:import>

<title>Login</title>
</head>

<body>
	<c:import url="/navbar.jsp"></c:import>
	
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
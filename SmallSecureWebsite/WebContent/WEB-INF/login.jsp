<%@ include file="../header.jsp" %>

<title>Login</title>
</head>

<body>
	<c:import url="/navbar.jsp"></c:import>
	
	<myTags:Error />
			
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
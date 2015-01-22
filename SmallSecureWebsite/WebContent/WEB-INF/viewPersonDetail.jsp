<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Detail</title>
</head>
<body >

<h2>${capName } Detail Page</h2>
<hr/>
	${user.ID } <br/>
	${user.name } <br/>
	${user.email } <br/>
	<br/>
	<a href="/SmallSecureWebsite/index.html">Home</a> <br/>
	<a href="/SmallSecureWebsite/listpeople">People List</a>
</body>
</html>
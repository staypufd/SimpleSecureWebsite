<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    
<title>Person Detail</title>
</head>
<body >
	<c:import url="/header.html"></c:import>
	
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
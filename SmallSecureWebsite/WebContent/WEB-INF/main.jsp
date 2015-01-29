<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
           
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<title>Main Page</title>
</head>
<body>
	<c:import url="/header.jsp">
		<c:param name="isLoggedIn" value="${isLoggedIn }"/>
	</c:import>

	<c:if test="${sessionScope.isLoggedIn == true}"> 
		<p class="alert alert-success" role="alert">Logged In!</p>
	</c:if>	


	<!--  Hello, ${ fn:toUpperCase(user.name) } -->
	Hello, ${capName }
	<br/>
	Your ID is: ${user.ID }<br/>
	Your email is: ${user.email} <br/>
	

	Logged In User is: ${capName}

	
	<p>Today is the day for all good humans to step up to the aid of their country! </p>
</body>
</html>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<c:import url="header.jsp"></c:import>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body style="background-image:url(images/fail-whale.jpg); background-size: 100% 550px;" >
	<c:import url="navbar.jsp"></c:import>
	<h1 class="text-danger">Error</h1>
	<h4 class="bg-danger col-md-6">There service is currently expiercing problems. Check back later.</h4>
	
</body>
</html>
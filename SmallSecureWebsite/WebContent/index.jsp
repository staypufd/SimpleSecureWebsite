<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<title>Company XYZ</title>
</head>
<body bgcolor="lightgrey">
	
	<c:import url="header.jsp"></c:import>

	<c:if test="${sessionScope.isLoggedIn == true}"> 
		<div class="jumbotron">
		  <h1>Hello,  ${capName }</h1>
				<p>People Who Need People</p>
				<p>-- Find people who need people like you --</p>
		  <p><a class="btn btn-primary btn-lg" href="learnmore.html" role="button">Learn more</a></p>
		</div>
	</c:if>

	<c:if test="${sessionScope.isLoggedIn == false}"> 
		<div class="jumbotron">
			<h1>Welcome to the ACC Demo Servlet Application!</h1>
			<p>Login to use our cool app!</p>
			<p><a class="btn btn-primary btn-lg" href="learnmore.html" role="button">Learn more</a></p>
		</div>
	</c:if>

</body>
</html>
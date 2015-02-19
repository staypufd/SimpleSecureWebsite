
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<sql:setDataSource dataSource="jdbc/DB" />

<c:import url="header.html"></c:import>


<title>Company XYZ</title>
</head>
<body bgcolor="lightgrey">

	<c:import url="navbar.jsp"></c:import>

	<c:if test="${sessionScope.isLoggedIn == true}">
		<div class="jumbotron">
		  <h1>Hello,  ${capName }</h1>
				<p>People Who Need People</p>
				<p>-- Find people who need people like you --</p>
		  <p><a class="btn btn-primary btn-lg" href="learnmore.html" role="button">Learn more</a></p>
		</div>
	</c:if>

	<c:if test="${ (sessionScope.isLoggedIn == false) or (empty isLoggedIn) }">
		<div class="jumbotron">
		
			<myTags:Header fontColor="#660099">
				Howdy ACC Class.  This is your first Cool tag.... <br/>
				-- Sam G.
			</myTags:Header>
		
			<h1>Welcome to the ACC Demo Servlet Application!</h1>
			<p>Login to use our cool app!</p>
			<p><a class="btn btn-primary btn-lg" href="learnmore.html" role="button">Learn more</a></p>
		</div>
	</c:if>

<%-- 	<myTags:userTable /> --%>

	<a class="btn btn-primary btn-lg" href='<c:url value="/users"/>' role="button">Go See Users</a>

</body>
</html>
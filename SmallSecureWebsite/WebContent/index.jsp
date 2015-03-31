<%@ include file="header.jsp" %>


<!-- <title>Company XYZ</title> -->
<!-- </head> -->
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
		
			<!-- Show error if there is one  -->
				<myTags:Error />
		
			<h1>Welcome to the ACC Demo Servlet Application!</h1>
			<p>Login to use our cool app!</p>
			<p><a class="btn btn-primary btn-lg" href="learnmore.html" role="button">Learn more</a></p>
		</div>
	</c:if>

<%-- 	<myTags:userTable /> --%>

<myTags:Footer/>
</body>
</html>

<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
           
<c:import url="/header.jsp"></c:import>

<title>Main Page</title>
</head>
<body>
	<c:import url="/navbar.jsp">
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
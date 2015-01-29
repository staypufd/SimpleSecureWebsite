
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<c:import url="/header.html"></c:import>

<title>Person Detail</title>
</head>
<body >
	<c:import url="/navbar.jsp"></c:import>
	
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
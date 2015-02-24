
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
           
<c:import url="/header.jsp"></c:import>

<title>Email Contacts</title>
</head>
<body>	

	<c:import url="/navbar.jsp"></c:import>

    <h4>People List</h4>
	<table class="table table-striped table-bordered table-hover table-condensed">
		<!--  <thead><td>Name</td><td>Email</td>
		</thead>	 -->
		
		<!-- The table header row -->
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>ID</th>
		</tr>	
		<!-- Table data rows -->
		<c:forEach items="${people }" var="person">
			<c:choose>
			    <c:when test="${ fn:contains(person.email, 'amazon.com')}">
			    	<tr class="danger">
			    </c:when>
			    <c:otherwise>
			    	<tr>
			    </c:otherwise>
			</c:choose>
				<!-- Rest of tr tag data items -->
				    	<td>${person.name}</td>
						<td>${person.email}</td>
						<td><a href="showperson?id=${person.ID }">${person.ID }</a></td>
					</tr>
			</c:forEach>
	</table>
	
	<hr/>
	<c:import url="/WEB-INF/headers-data.jsp"></c:import>
	
</body>
</html>
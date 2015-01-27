<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">

<title>Email Contacts</title>
</head>
<body>	

	<c:import url="/header.jsp"></c:import>

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
			    <c:when test="${! fn:contains(person.email, 'foo.com')}">
			       <tr class="danger">
							<td>${person.name}</td>
							<td>${person.email}</td>
							<td><a href="/SmallSecureWebsite/showperson?id=${person.ID }">${person.ID }</a></td>
						</tr>
			    </c:when>
			    <c:otherwise>
			    		<tr>
							<td>${person.name}</td>
							<td>${person.email}</td>
							<td><a href="/SmallSecureWebsite/showperson?id=${person.ID }">${person.ID }</a></td>
						</tr>
			    </c:otherwise>
			</c:choose>
			</c:forEach>
	</table>
	
	<hr/>
	<c:import url="/WEB-INF/headers-data.jsp"></c:import>
	
</body>
</html>
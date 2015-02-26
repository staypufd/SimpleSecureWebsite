<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<c:import url="/header.jsp"></c:import>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Layout Page</title>
</head>
<body>
  <myTags:common-body>
  
  	<h2>Body is here</h2>
  	<img src="images/image1.jpg">
  	<p>Now is the time for all good whales to swim to the aid of their pod!</p>
  	<br/>
  	<p>foobar</p>
  
  </myTags:common-body>
</body>
</html>
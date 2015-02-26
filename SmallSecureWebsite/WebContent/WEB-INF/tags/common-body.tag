<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<c:import url="/navbar.jsp"></c:import>

<%-- <myTags:Header fontColor="red">ACC App</myTags:Header> --%>
<myTags:Header>ACC App</myTags:Header>

	<div class="container-fluid">
		<jsp:doBody />
	</div>
 <myTags:Footer />
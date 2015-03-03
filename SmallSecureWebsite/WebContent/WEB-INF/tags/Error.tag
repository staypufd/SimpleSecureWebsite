
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<%@ tag body-content="tagdependent" %>

<!-- <em> -->
<!-- 	<strong> -->
<%-- 		<font color="${fontColor }"> --%>
<%-- 			<jsp:doBody /> --%>
<!-- 		</font> -->
<!-- 	</strong> -->
<!-- </em> -->

<c:if test="${not empty error}" >
	<div class="panel panel-danger">
	  <div class="panel-heading">
	    <h3 class="panel-title">Error</h3>
	  </div>
	  <div class="panel-body">
	    ${error}
	  </div>
	</div>
</c:if>
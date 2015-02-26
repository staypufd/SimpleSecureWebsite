<%-- <%@ attribute name="fontColor" required="true" %> --%>
<%@ tag body-content="tagdependent" %>

<!-- <em> -->
<!-- 	<strong> -->
<%-- 		<font color="${fontColor }"> --%>
<%-- 			<jsp:doBody /> --%>
<!-- 		</font> -->
<!-- 	</strong> -->
<!-- </em> -->

<div class="panel panel-danger">
  <div class="panel-heading">
    <h3 class="panel-title">Error</h3>
  </div>
  <div class="panel-body">
    ${error}
  </div>
</div>
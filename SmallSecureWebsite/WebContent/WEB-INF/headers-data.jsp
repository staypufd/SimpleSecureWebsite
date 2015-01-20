<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

	<h3>Header Data</h3>
	<table class="table-condensed">
		<c:forEach items="${header}"  var="req">
			<tr>
				<td>
			    <strong>
			    	<c:out value="${req.key}"/>
			    </strong>
		    </td>
		    <td>
		    	<c:out value="${req.value}"/>
			</td>
			</tr>
		</c:forEach>
	</table>

	<p>Sam added this</p>
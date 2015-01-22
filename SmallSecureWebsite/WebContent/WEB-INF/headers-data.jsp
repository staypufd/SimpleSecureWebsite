<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

	<h3>Header Data</h3>
	<table class="table-condensed table-striped">
		<c:forEach items="${header}"  var="item">
			<tr>
				<td>
			    <strong>
			    	<c:out value="${item.key}"/>
			    </strong>
		    </td>
		    <td>
		    	<c:out value="${item.value}"/>
			</td>
			</tr>
		</c:forEach>
	</table>

	<p>Sam added this</p>
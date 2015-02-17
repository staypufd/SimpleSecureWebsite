<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="userName" required="true" %>
<%@ attribute name="userID" required="true" %>
<%@ tag body-content="tagdependent" %>



<td><c:out value="${userName}" /></td>
<td><c:out value="${userID}" /></td>
<td>Hi</td>

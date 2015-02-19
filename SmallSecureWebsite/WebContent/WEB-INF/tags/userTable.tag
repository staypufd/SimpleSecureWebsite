<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<sql:setDataSource dataSource="jdbc/DB" />

<%@ tag body-content="tagdependent" %>

<hr/>
 <table border='1'>
       <tr><th>Worker</th><th>Comment</th><th>Greeting</th></tr>

<%--        <sql:query var="qryPosts" > --%>
<!--                   SELECT * FROM ACC_USER WHERE NAME LIKE '%S%'  -->
<%--        </sql:query> --%>
       
       <sql:query var="qryPosts" >
                  SELECT * FROM RECIPE
       </sql:query>

       <c:forEach var="row" items="${qryPosts.rows}">
        <tr>
          <myTags:showUser userID="${row.ID }" userName="${row.NAME }" />
        </tr>
       </c:forEach>

 </table>
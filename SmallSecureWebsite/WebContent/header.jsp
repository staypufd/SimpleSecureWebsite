
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%-- Includes the common html, css and javascript libraries we use on this site --%>
<%-- a JSP include does a pull in of the code in the referenced file. --%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<sql:setDataSource dataSource="jdbc/DB" />

<%@ include file="/common-css-javascript.html" %> 	

<title>${title }</title>
</head>
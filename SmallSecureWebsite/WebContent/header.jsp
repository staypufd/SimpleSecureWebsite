<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<!-- To show the user object we can do this -->
<%-- User is:  ${sessionScope.user } --%>

<nav class="navbar navbar-inverse">
     <div class="container-fluid">
       <!-- Brand and toggle get grouped for better mobile display -->
       <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="#">ACC Site</a>
       </div>
	
       <!-- Collect the nav links, forms, and other content for toggling -->
       <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
         <ul class="nav navbar-nav">
           <li class="active"><a href="index.jsp">Home</a></li>
           <c:if test="${isLoggedIn == false }">
           	<li><a href="/SmallSecureWebsite/login?age=24&color=red">Login</a></li>
           </c:if>
           <c:if test="${isLoggedIn == true }">
           	<li><a href="/SmallSecureWebsite/listpeople">List People</a></li>
           	<li><a href="/SmallSecureWebsite/adduser">Add User</a></li>
	         </ul>
	         <ul class="nav navbar-nav navbar-right">
	         	<li><a href="/SmallSecureWebsite/logout">Logout</a></li>
	         </ul>
           </c:if>
       </div><!-- /.navbar-collapse -->
     </div><!-- /.container-fluid -->
   </nav>
    
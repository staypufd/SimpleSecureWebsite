<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>  
           
<!-- Bootstrap -->
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    
<title>Add User</title>
</head>
<body>

	<c:import url="/header.jsp"></c:import>
	
	<h1>Add User</h1>
	<div class="col-md-8">
		<img src="http://apod.nasa.gov/apod/image/1501/GalacticMagneticField_planck_960.jpg" 
			class="img-circle"
			height="100px" width="100px">
			
	</div>
	<hr class="col-md-12"/>
	<div class="col-md-offset-1 col-md-8">
		<form class="form-horizontal"  action="AddUserServlet" method="post">
			<input type="hidden" name="action" value="add-user">
			
			<div class="form-group">
				<label class="text-danger" >Name:</label>
				<input class="form-control" type="text" name="name" required><br/>
			</div>
			
			<div class="form-group">
			<label>Email:</label>
			<input class="form-control" type="text" name="email" required><br/>
			</div>
	
			<div class="form-group">
				<label >Password:</label>
				<input class="form-control" type="password" name="password" required><br/>
			</div>
	
			<div class="form-group">
				<label >Verify Password:</label>
				<input class="form-control" type="password" name="verify_password" required><br/>
			</div>
			
			<label >&nbsp;</label>
			<input class="btn btn-primary active"  type="submit" value="Add User" id="submit">
	
		</form>
	</div>
</body>
</html>
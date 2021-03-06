

<%@ include file="/header.jsp" %>


</head>
<body>

<c:import url="/navbar.jsp"></c:import>

    <h4>Vehicle List</h4>
	<table class="table table-striped table-bordered table-hover table-condensed">
		<!--  <thead><td>Name</td><td>Email</td>
		</thead>	 -->
		
		<!-- The table header row -->
		<tr>
			<th>Make</th>
			<th>Model</th>
			<th>Color</th>
			<th>Year</th>
			<th>Mileage</th>
			<th>Detail Link</th>
		</tr>	
		<!-- Table data rows -->
		<c:forEach items="${vehicles }" var="vehicle">
			<tr>
				<!-- Rest of tr tag data items -->
		    	<td>${vehicle.make}</td>
				<td>${vehicle.model}</td>
				<td>${vehicle.color}</td>
				<td>${vehicle.year}</td>
				<td>${vehicle.mileage}</td>
				<td>

					<a class="btn btn-default btn-xs" href="editVehicle?id=${vehicle.id }">Edit</a>
					<form class="form-horizontal"  action="deleteVehicle" method="post">
						<input type="hidden" name="id" value="${vehicle.id }">
						<input class="btn btn-xs btn-danger"  type="submit" value="Delete" id="submit">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="btn btn-primary" href="/SmallSecureWebsite/addVehicle">Add Vehicle</a>
<myTags:Footer/>
	
</body>
</html>
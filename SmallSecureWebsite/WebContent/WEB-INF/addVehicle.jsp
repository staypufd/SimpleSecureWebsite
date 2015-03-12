<%@ include file="/header.jsp" %>

</head>
<body>

<c:import url="/navbar.jsp"></c:import>
		<h1>Add Vehicle</h1>

		<hr class="col-md-12"/>
		<div class="col-md-offset-1 col-md-8">
			<form class="form-horizontal"  action="addVehicle" method="post">
				<input type="hidden" name="action" value="add-vehicle">

				<div class="form-group">
					<label>Make:</label>
					<input class="form-control" type="text" name="make" value="${vehicle.make }" required><br/>
				</div>
				
				<div class="form-group">
				<label>Model:</label>
				<input class="form-control" type="text" name="model" value="${vehicle.model }"required><br/>
				</div>
		
				<div class="form-group">
					<label >Color:</label>
					<input class="form-control" type="text" name="color" value="${vehicle.color }"required><br/>
				</div>
		
				<div class="form-group">
					<label >Year:</label>
					<input class="form-control" type="number" name="year" value="${vehicle.year }"required><br/>
				</div>
				
				<div class="form-group">
					<label >Mileage:</label>
					<input class="form-control" type="number" name="mileage" value="${vehicle.mileage }" required><br/>
				</div>

				
				<label >&nbsp;</label>
				<input class="btn btn-primary active"  type="submit" value="Save Vehicle" id="submit">
		
			</form>
		</div>


</body>
</html>
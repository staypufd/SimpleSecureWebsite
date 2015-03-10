SET SCHEMA APP;

CREATE TABLE VEHICLES 
	(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
	make VARCHAR(40) NOT NULL, 
	model VARCHAR(40) NOT NULL,
	theYear INT NOT NULL,
	mileage INT NOT NULL,
	color VARCHAR(15) NOT NULL
	);
	
INSERT INTO VEHICLES (make, model, theYear, mileage, color)  values ('Lincoln', 'Navigator', 1978, 300000, 'Silver');
INSERT INTO VEHICLES (make, model, theYear, mileage, color)  values ('Honda', 'Accord', 2009, 45000, 'Red');


update VEHICLES set theYear = 2009, color = 'Green' where id = 2;

select * from vehicles;

select * from vehicles where color = 'Green';
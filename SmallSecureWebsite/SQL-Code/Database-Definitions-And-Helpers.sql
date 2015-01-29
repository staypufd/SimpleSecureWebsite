CREATE TABLE ACC_USER (ID INT PRIMARY KEY NOT NULL, NAME VARCHAR(14), PASSWORD VARCHAR(16), EMAIL VARCHAR(80));

DROP TABLE ACC_USER;


INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
	VALUES (1, 'Sam Griffith', 'abc', 'sam@foobar.com');
	
INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
	VALUES (2, 'Sally Ride', 'abc', 'sally@nasa.com');
	
INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
	VALUES (3, 'Jeff Bezos', 'abc', 'jeff.b@amazon.com');
	
SELECT * FROM ACC_USER;
SET SCHEMA APP;

CREATE TABLE ACC_USER (ID INT PRIMARY KEY NOT NULL, NAME VARCHAR(14) NOT NULL, PASSWORD VARCHAR(16) NOT NULL, EMAIL VARCHAR(80) NOT NULL);

INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
	VALUES (1, 'Sam Griffith', 'abc', 'sam@foobar.com'),
	(2, 'Sally Ride', 'abc', 'sally@nasa.com'),
	(3, 'Jeff Bezos', 'abc', 'jeff.b@amazon.com');

--INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
--	VALUES (2, 'Sally Ride', 'abc', 'sally@nasa.com');
--
--INSERT INTO ACC_USER (ID, NAME, PASSWORD, EMAIL)
--	VALUES (3, 'Jeff Bezos', 'abc', 'jeff.b@amazon.com');

SELECT * FROM ACC_USER;

-- Select an ID
SELECT * FROM ACC_USER WHERE ID = 3;
-- Select a NAME matching a pattern
SELECT * FROM ACC_USER WHERE NAME LIKE '%S%';


SELECT * FROM ACC_USER;


-- DROP TABLE ACC_USER;
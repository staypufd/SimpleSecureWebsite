SET SCHEMA APP;

CREATE TABLE ACC_USER (ID BIGINT PRIMARY KEY NOT NULL, UUID VARCHAR(100) NOT NULL, NAME VARCHAR(14) NOT NULL, PASSWORD VARCHAR(16) NOT NULL, EMAIL VARCHAR(80) NOT NULL);

INSERT INTO ACC_USER (ID, UUID, NAME, PASSWORD, EMAIL)
	VALUES (1, '067e6162-3b6f-4ae2-a171-2470b63dff00', 'Sam Griffith', 'abc', 'sam@foobar.com'),
	(2, '54947df8-0e9e-4471-a2f9-9af509fb5889', 'Sally Ride', 'abc', 'sally@nasa.com'),
	(3, '38400000-8cf0-11bd-b23e-10b96e4ef00d','Jeff Bezos', 'abc', 'jeff.b@amazon.com');
	
DROP TABLE ACC_USER;

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
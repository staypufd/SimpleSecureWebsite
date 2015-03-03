SET SCHEMA APP;

CREATE TABLE RECIPE 
	(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
	NAME VARCHAR(30) NOT NULL, 
	DESCRIPTION VARCHAR(200)
	);
	
DROP TABLE RECIPE;
	
insert into RECIPE(NAME,DESCRIPTION) values('Tomato Surprise','Yummy tomatoeee guuuulooooosssshhhh');
insert into RECIPE(NAME,DESCRIPTION) values('Grilled Cheese','Globs of melted love!');

select * from RECIPE;

SELECT COUNT(*) FROM APP.ACC_USER;

DROP TABLE INGREDIENTS;

CREATE TABLE INGREDIENTS(
id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NAME VARCHAR(50) NOT NULL,
QUANTITY INT NOT NULL,
UNITS VARCHAR(20) NOT NULL,
RECIPE_ID INT NOT NULL
)

DROP TABLE INGREDIENTS;

insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'KRAFT America Cheese', 2, 'Slices', 2);
insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Buttercrust Texas Toast', 2, 'Slices', 2);
insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Real Butter', 1, 'Stick', 2);

insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Real Butter', 1, 'Stick', 1);
insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Sale', 1, 'pinch', 1);
insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Tomatoe', 4, 'pounds', 1);
insert into INGREDIENTS( NAME, QUANTITY, UNITS, RECIPE_ID) values( 'Vegemite', 1, 'Stick', 1);

select * from INGREDIENTS WHERE RECIPE_ID = 2;

select * from INGREDIENTS WHERE RECIPE_ID = 1;

-- All the recipes and all the ingredients and show all columns from both tables
select * from INGREDIENTS, RECIPE WHERE RECIPE.ID = INGREDIENTS.RECIPE_ID;

-- All the recipes and all the ingredients but only show these columns
select RECIPE.NAME, RECIPE.DESCRIPTION, INGREDIENTS.NAME, INGREDIENTS.QUANTITY, INGREDIENTS.UNITS 
from INGREDIENTS, RECIPE 
WHERE RECIPE.ID = INGREDIENTS.RECIPE_ID;

-- Get the recipe and ingredient columns where the recipe.id and ingredients.recipe_id are the same 
-- but for only one recipe.id
select RECIPE.NAME as RNAME, RECIPE.DESCRIPTION, INGREDIENTS.NAME as INAME, INGREDIENTS.QUANTITY, INGREDIENTS.UNITS 
from INGREDIENTS, RECIPE 
AND RECIPE.ID = 1
ORDER BY QUANTITY DESC, INAME DESC;

select ID, UUID, NAME, PASSWORD, EMAIL from ACC_USER;


-- Get the recipe and ingredient columns where the recipe.id and ingredients.recipe_id are the same 
-- but for only one recipe.id
select R.NAME as RNAME, R.DESCRIPTION, I.NAME as INAME, I.QUANTITY, I.UNITS 
from INGREDIENTS AS I, RECIPE AS R
WHERE R.ID = I.RECIPE_ID 
ORDER BY RNAME, INAME;

select RECIPE.name from ingredients, RECIPE where recipe.id = ingredients.recipe_id AND quantity > 3;

select I.NAME, COUNT(*) AS COUNT
from INGREDIENTS AS I
GROUP BY I.NAME
ORDER BY COUNT DESC;

SELECT ID FROM RECIPE;







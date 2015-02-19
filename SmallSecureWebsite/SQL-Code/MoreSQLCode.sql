SET SCHEMA APP;

CREATE TABLE RECIPE 
	(ID INT PRIMARY KEY NOT NULL, 
	NAME VARCHAR(30) NOT NULL, 
	DESCRIPTION VARCHAR(200)
	);
	
insert into RECIPE(ID, NAME,DESCRIPTION) values(1, 'Tomato Surprise','Yummy tomatoeee guuuulooooosssshhhh');
insert into RECIPE(ID, NAME,DESCRIPTION) values(2, 'Grilled Cheese','Globs of melted love!');

select * from RECIPE;

SELECT COUNT(*) FROM APP.ACC_USER;

CREATE TABLE INGREDIENTS(
ID INT PRIMARY KEY NOT NULL,
NAME VARCHAR(50) NOT NULL,
QUANTITY INT NOT NULL,
UNITS VARCHAR(20) NOT NULL,
RECIPE_ID INT NOT NULL
)

DROP TABLE INGREDIENTS;

insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(1, 'KRAFT America Cheese', 2, 'Slices', 2);
insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(2, 'Buttercrust Texas Toast', 2, 'Slices', 2);
insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(3, 'Real Butter', 1, 'Stick', 2);

insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(4, 'Real Butter', 1, 'Stick', 1);
insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(5, 'Sale', 1, 'pinch', 1);
insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(6, 'Tomatoe', 4, 'pounds', 1);
insert into INGREDIENTS(ID, NAME, QUANTITY, UNITS, RECIPE_ID) values(7, 'Vegemite', 1, 'Stick', 1);

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
select RECIPE.NAME, RECIPE.DESCRIPTION, INGREDIENTS.NAME, INGREDIENTS.QUANTITY, INGREDIENTS.UNITS 
from INGREDIENTS, RECIPE 
WHERE RECIPE.ID = INGREDIENTS.RECIPE_ID AND RECIPE.ID = 1;



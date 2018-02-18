DROP table TODO_LIST if exists;
CREATE TABLE TODO_LIST(
	ID INT PRIMARY KEY auto_increment, 
	ITEM VARCHAR(255) not null, 
	DATE_CREATED date not null, 
	DATE_DUE date not null, 
	DATE_COMPLETED date, 
	STATUS char(1) not null);
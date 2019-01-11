
--Create Database
CREATE database TaskManagerDB;

--Create PARENT_TASK Table
CREATE TABLE TaskManagerDB.parent_task (
	PARENT_ID INT NOT NULL,
	PARENT_TASK VARCHAR(25),
	PRIMARY KEY (PARENT_ID)
);

--Insert Master Data in Parent table
INSERT INTO parent_task VALUES(1,'Parent One');
INSERT INTO parent_task VALUES(2,'Parent Two');
INSERT INTO parent_task VALUES(2,'Parent Three');

--Create TASK table
CREATE TABLE TaskManagerDB.task (
	TASK_ID INT NOT NULL AUTO_INCREMENT,
	PARENT_ID INT,
	TASK VARCHAR(25),
	START_DATE DATE,
	END_DATE DATE,
	PRIORITY VARCHAR(25),
	PRIMARY KEY (TASK_ID)
);
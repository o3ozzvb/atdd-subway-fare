SET REFERENTIAL_INTEGRITY FALSE;
TRUNCATE TABLE STATION;
TRUNCATE TABLE LINE;
TRUNCATE TABLE SECTION;
ALTER TABLE STATION ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE LINE ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE SECTION ALTER COLUMN ID RESTART WITH 1;
SET REFERENTIAL_INTEGRITY TRUE;
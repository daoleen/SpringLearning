CREATE TABLE BOOK (
  ID INT NOT NULL AUTO_INCREMENT ,
  NAME VARCHAR(60) NOT NULL ,
  YEAR INT NOT NULL,
  PAGES_COUNT INT,
  CREATED_AT DATE,                -- for demonstrating purposes only (@Temporary)
  VERSION INT NOT NULL DEFAULT 0, -- for optimistic concurrency      (@Version)
  PRIMARY KEY (ID)
);
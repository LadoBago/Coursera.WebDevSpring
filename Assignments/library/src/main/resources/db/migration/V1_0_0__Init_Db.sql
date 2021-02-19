CREATE SEQUENCE book_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE book (
  id integer NOT NULL DEFAULT nextval('book_id_seq'),
  title VARCHAR (255),
  description VARCHAR (255),
  PRIMARY KEY (id));
  
 CREATE SEQUENCE author_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE author (
  id integer NOT NULL DEFAULT nextval('author_id_seq'),
  name VARCHAR (255),
  PRIMARY KEY (id));
  
 CREATE TABLE book_author (
  book_id integer NOT NULL ,
  author_id integer NOT NULL ,
  PRIMARY KEY (book_id, author_id));

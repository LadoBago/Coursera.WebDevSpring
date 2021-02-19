ALTER TABLE if EXISTS book_author
ADD CONSTRAINT book_fk
FOREIGN KEY (book_id) REFERENCES book;

ALTER TABLE if EXISTS book_author
ADD CONSTRAINT author_fk
FOREIGN KEY (author_id) REFERENCES author;

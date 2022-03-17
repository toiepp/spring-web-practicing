DROP TABLE IF EXISTS customer;
DROP SEQUENCE IF EXISTS customer_id_seq;

CREATE SEQUENCE customer_id_seq START WITH 1;

CREATE TABLE customer
(
	id         integer     NOT NULL DEFAULT NEXTVAL('customer_id_seq'),
	first_name varchar(45) NOT NULL,
	last_name  varchar(45) NOT NULL,
	email      varchar(45) NOT NULL UNIQUE
);

INSERT INTO customer (first_name, last_name, email)
VALUES ('David', 'Adams', 'adams@yahoo.com');
INSERT INTO customer (first_name, last_name, email)
VALUES ('John', 'Doe', 'johndoe@gmail.com');
INSERT INTO customer (first_name, last_name, email)
VALUES ('Mary', 'Private', 'privatemary@gmail.com');
INSERT INTO customer (first_name, last_name, email)
VALUES ('Nicolai', 'Malkovich', 'malcokich_n@yandex.ru');
INSERT INTO customer (first_name, last_name, email)
VALUES ('Johnny', 'Silverhand', 'silverhand@protonmail.com');


SELECT * from customer;
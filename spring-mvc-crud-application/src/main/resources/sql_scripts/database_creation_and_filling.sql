DROP TABLE IF EXISTS customers;
DROP SEQUENCE IF EXISTS customer_id_seq;

CREATE SEQUENCE customer_id_seq START WITH 1;

CREATE TABLE customers
(
	id         integer     NOT NULL DEFAULT NEXTVAL('customer_id_seq'),
	first_name varchar(45) NOT NULL,
	last_name  varchar(45) NOT NULL,
	email      varchar(45) NOT NULL
);

INSERT INTO customers (first_name, last_name, email)
VALUES ('David', 'Adams', 'adams@yahoo.com');
INSERT INTO customers (first_name, last_name, email)
VALUES ('John', 'Doe', 'johndoe@gmail.com');
INSERT INTO customers (first_name, last_name, email)
VALUES ('Mary', 'Private', 'privatemary@gmail.com');
INSERT INTO customers (first_name, last_name, email)
VALUES ('Nicolai', 'Malkovich', 'malcokich_n@yandex.ru');
INSERT INTO customers (first_name, last_name, email)
VALUES ('Johnny', 'Silverhand', 'silverhand@protonmail.com');


SELECT *
FROM customers;
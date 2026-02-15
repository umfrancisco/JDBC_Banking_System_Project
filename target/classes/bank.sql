CREATE DATABASE bank;

USE bank;

CREATE TABLE bank(
	bank_number INT NOT NULL,
    bank_name TEXT NOT NULL,
    PRIMARY KEY (bank_number)
);

CREATE TABLE customer(
	customer_id INT NOT NULL,
	customer_name TEXT NOT NULL,
	bank_number INT NOT NULL,
    customer_amount FLOAT,
    PRIMARY KEY (customer_id),
    FOREIGN KEY (bank_number) REFERENCES bank (bank_number)
);


DESC bank;
DESC customer;

INSERT INTO bank (bank_number, bank_name) values
(100, 'São Paulo'),
(200, 'New York'),
(300, 'Buenos Aires'),
(400, 'San Tiago'),
(500, 'Bogotá'),
(600, 'Montevideo');

SELECT * FROM bank;
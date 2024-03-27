CREATE DATABASE PeopleDB;
GO
USE PeopleDB;
GO
CREATE TABLE Persons (
    person_id INT PRIMARY KEY IDENTITY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE
);

CREATE TABLE Addresses (
    address_id INT PRIMARY KEY IDENTITY,
    person_id INT,
    address_line VARCHAR(100),
    city VARCHAR(50),
    postal_code VARCHAR(10),
    type VARCHAR(20),
    FOREIGN KEY (person_id) REFERENCES Persons(person_id)
);

CREATE TABLE Contacts (
    contact_id INT PRIMARY KEY IDENTITY,
    person_id INT,
    contact_type VARCHAR(20),
    contact_info VARCHAR(100),
    FOREIGN KEY (person_id) REFERENCES Persons(person_id)
);

INSERT INTO Persons (first_name, last_name, birth_date)
VALUES ('John', 'Dear', '1990-05-15'),
       ('Agent', 'Smith', '1985-09-23'),
       ('Bob', 'Dilan', '1978-03-10');

INSERT INTO Addresses (person_id, address_line, city, postal_code, type)
VALUES (1, '123 Main Street', 'New York', '54321', 'Permanent'),
       (1, '456 Elm Street', 'Last Vegas', '97531', 'Temporary'),
       (2, '789 Oak Avenue', 'Alabama', '12345', 'Permanent');

INSERT INTO Contacts (person_id, contact_type, contact_info)
VALUES (1, 'Email', 'john.dear@dearcorp.com'),
       (1, 'Phone', '123-456-7890'),
       (2, 'Email', 'agent.smith@matrix.com'),
       (3, 'Phone', '987-654-3210');


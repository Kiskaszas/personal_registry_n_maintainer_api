CREATE DATABASE PeopleDB;

USE PeopleDB;

CREATE TABLE Person (
    person_id INT PRIMARY KEY IDENTITY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE
);

CREATE TABLE Address (
    address_id INT PRIMARY KEY IDENTITY,
    person_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    postal_code VARCHAR(10),
    type VARCHAR(20),
    FOREIGN KEY (person_id) REFERENCES Person(person_id)
);

CREATE TABLE Contact (
    contact_id INT PRIMARY KEY IDENTITY,
    person_id INT,
    contact_type VARCHAR(20),
    contact_info VARCHAR(100),
    FOREIGN KEY (person_id) REFERENCES Person(person_id)
);

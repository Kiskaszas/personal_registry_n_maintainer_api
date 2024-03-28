INSERT INTO Person (first_name, last_name, birth_date)
VALUES ('John', 'Dear', '1990-05-15'),
       ('Agent', 'Smith', '1985-09-23'),
       ('Bob', 'Dilan', '1978-03-10');

INSERT INTO Address (person_id, street, city, postal_code, type)
VALUES (1, '123 Main Street', 'New York', '54321', 'PERMANENT'),
       (1, '456 Elm Street', 'Last Vegas', '97531', 'TEMPORARY'),
       (2, '789 Oak Avenue', 'Matrix', '12345', 'PERMANENT');

INSERT INTO Contact (person_id, contact_type, contact_info)
VALUES (1, 'Email', 'john.dear@dearcorp.com'),
       (1, 'Phone', '123-456-7890'),
       (2, 'Email', 'agent.smith@matrix.com'),
       (3, 'Phone', '987-654-3210');
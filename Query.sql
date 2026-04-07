

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('BUSINESS');
INSERT INTO roles (name) VALUES ('CUSTOMER');

INSERT INTO users (username, email, encrypted_password, family_name, given_name, gender)
VALUES ('admin', 'admin@istad.co', '$2a$12$l2wW9De8QS4kzQW2to5br.HJYusF5H2X6Ru.5KhfPQLjC1IDKLgPW', 'Chan', 'Chhaya', 'Male'),
       ('business', 'business@istad.co', '$2a$12$l2wW9De8QS4kzQW2to5br.HJYusF5H2X6Ru.5KhfPQLjC1IDKLgPW', 'Chan', 'Dara', 'Male'),
       ('customer', 'customer@istad.co', '$2a$12$l2wW9De8QS4kzQW2to5br.HJYusF5H2X6Ru.5KhfPQLjC1IDKLgPW', 'Chan', 'Kanha', 'Female');

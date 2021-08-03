INSERT INTO country (name) VALUES ('India');
INSERT INTO country (name) VALUES ('Brazil');
INSERT INTO country (name) VALUES ('USA');
INSERT INTO country (name) VALUES ('Italy');

INSERT INTO user (name, password, role_id)
VALUES ('A', 'A', 1),
       ('B', 'B', 1),
       ('C', 'C', 2),
       ('D', 'D', 3);
INSERT INTO role (name, authority_id)
VALUES ('admin', 0),
       ('public', 1);

INSERT INTO authority (name, code, desc)
VALUES ('ADMIN', 1, '==admin=='),
       ('PUBLIC', 2, '==public==');
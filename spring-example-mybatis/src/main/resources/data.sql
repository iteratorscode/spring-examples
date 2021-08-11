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
VALUES ('admin', 1),
       ('public', 2),
       ('specific', 2);

INSERT INTO authority (name, code, desc)
VALUES ('ADMIN', 1, '==admin=='),
       ('PUBLIC', 2, '==public==');

INSERT INTO user_role_rel (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (3, 2),
       (4, 2);
INSERT INTO role_authority_rel (role_id, authority_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 2);
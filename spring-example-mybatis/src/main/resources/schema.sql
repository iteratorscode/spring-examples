DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`
(
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    name     VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    role_id  BIGINT       NOT NULL DEFAULT '0',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    name         VARCHAR(128) NOT NULL,
    authority_id BIGINT       NOT NULL DEFAULT '0',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    code INT          NOT NULL DEFAULT '0',
    desc VARCHAR      NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);
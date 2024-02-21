-- liquibase formatted sql
-- changeset michaltu:6
CREATE TABLE games (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name varchar(30)
);
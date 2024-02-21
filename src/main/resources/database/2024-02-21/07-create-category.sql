-- liquibase formatted sql
-- changeset michaltu:7
CREATE TABLE Categories
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id),
    game_id BIGINT,
    FOREIGN KEY (game_id) REFERENCES GAMES(id)
);
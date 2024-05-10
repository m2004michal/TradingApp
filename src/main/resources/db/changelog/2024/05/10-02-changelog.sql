-- liquibase formatted sql

-- changeset micha:1715360690582-1
ALTER TABLE category
    ADD game_id BIGINT;

-- changeset micha:1715360690582-2
ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_GAME FOREIGN KEY (game_id) REFERENCES game (id);


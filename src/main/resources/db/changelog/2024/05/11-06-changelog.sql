-- liquibase formatted sql

-- changeset micha:1715445704007-3
ALTER TABLE CATEGORY DROP CONSTRAINT FK_CATEGORY_ON_CATEGORY;

-- changeset micha:1715445704007-1
ALTER TABLE category
    ADD game_id BIGINT;

-- changeset micha:1715445704007-2
ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_GAME FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715445704007-4
ALTER TABLE CATEGORY DROP COLUMN CATEGORY_ID;

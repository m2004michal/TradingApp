-- liquibase formatted sql

-- changeset micha:1715427585990-4
ALTER TABLE CATEGORY DROP CONSTRAINT FK_CATEGORY_ON_GAME;

-- changeset micha:1715427585990-5
ALTER TABLE GAME_CATEGORIES DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715427585990-6
ALTER TABLE GAME_CATEGORIES DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715427585990-1
CREATE TABLE game_category
(
    category_id BIGINT NOT NULL,
    game_id     BIGINT NOT NULL,
    CONSTRAINT pk_game_category PRIMARY KEY (category_id, game_id)
);

-- changeset micha:1715427585990-2
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715427585990-3
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715427585990-8
DROP TABLE GAME_CATEGORIES CASCADE;

-- changeset micha:1715427585990-9
ALTER TABLE CATEGORY DROP COLUMN GAME_ID;


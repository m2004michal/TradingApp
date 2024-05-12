-- liquibase formatted sql

-- changeset micha:1715445877799-5
ALTER TABLE GAME_CATEGORIES DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715445877799-6
ALTER TABLE GAME_CATEGORIES DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715445877799-1
CREATE TABLE game_category
(
    category_id BIGINT NOT NULL,
    game_id     BIGINT NOT NULL,
    CONSTRAINT pk_game_category PRIMARY KEY (category_id, game_id)
);

-- changeset micha:1715445877799-2
ALTER TABLE game_category
    ADD CONSTRAINT uc_game_category_category UNIQUE (category_id);

-- changeset micha:1715445877799-3
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715445877799-4
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715445877799-8
DROP TABLE GAME_CATEGORIES CASCADE;


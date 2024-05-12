-- liquibase formatted sql

-- changeset micha:1715445557091-7
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715445557091-8
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715445557091-1
CREATE TABLE game_categories
(
    game_id       BIGINT NOT NULL,
    categories_id BIGINT NOT NULL,
    CONSTRAINT pk_game_categories PRIMARY KEY (game_id, categories_id)
);

-- changeset micha:1715445557091-2
ALTER TABLE category
    ADD category_id BIGINT;

-- changeset micha:1715445557091-3
ALTER TABLE game_categories
    ADD CONSTRAINT uc_game_categories_categories UNIQUE (categories_id);

-- changeset micha:1715445557091-4
ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES game (id);

-- changeset micha:1715445557091-5
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (categories_id) REFERENCES category (id);

-- changeset micha:1715445557091-6
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715445557091-9
DROP TABLE GAME_CATEGORY CASCADE;


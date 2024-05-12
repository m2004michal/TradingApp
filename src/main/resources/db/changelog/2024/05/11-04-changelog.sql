-- liquibase formatted sql

-- changeset micha:1715430164696-3
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715430164696-4
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715430164696-1
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715430164696-2
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);


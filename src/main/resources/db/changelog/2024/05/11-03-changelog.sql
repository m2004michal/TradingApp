-- liquibase formatted sql

-- changeset micha:1715429437724-3
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715429437724-4
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715429437724-1
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (game_id) REFERENCES category (id);

-- changeset micha:1715429437724-2
ALTER TABLE game_category
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (category_id) REFERENCES game (id);


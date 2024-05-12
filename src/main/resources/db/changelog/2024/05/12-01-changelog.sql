-- liquibase formatted sql

-- changeset micha:1715525643592-12
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_CATEGORY;

-- changeset micha:1715525643592-13
ALTER TABLE GAME_CATEGORY DROP CONSTRAINT FK_GAMCAT_ON_GAME;

-- changeset micha:1715525643592-1
CREATE TABLE category_listings
(
    category_id BIGINT NOT NULL,
    listings_id BIGINT NOT NULL
);

-- changeset micha:1715525643592-2
CREATE TABLE game_categories
(
    category_id BIGINT NOT NULL,
    game_id     BIGINT NOT NULL,
    CONSTRAINT pk_game_categories PRIMARY KEY (category_id, game_id)
);

-- changeset micha:1715525643592-3
ALTER TABLE category
    ADD games_id BIGINT;

-- changeset micha:1715525643592-4
ALTER TABLE category
    ALTER COLUMN games_id SET NOT NULL;

-- changeset micha:1715525643592-5
ALTER TABLE category_listings
    ADD CONSTRAINT uc_category_listings_listings UNIQUE (listings_id);

-- changeset micha:1715525643592-6
ALTER TABLE game_categories
    ADD CONSTRAINT uc_game_categories_category UNIQUE (category_id);

-- changeset micha:1715525643592-7
ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_GAMES FOREIGN KEY (games_id) REFERENCES game (id);

-- changeset micha:1715525643592-8
ALTER TABLE category_listings
    ADD CONSTRAINT fk_catlis_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715525643592-9
ALTER TABLE category_listings
    ADD CONSTRAINT fk_catlis_on_listing FOREIGN KEY (listings_id) REFERENCES listing (id);

-- changeset micha:1715525643592-10
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715525643592-11
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715525643592-15
DROP TABLE GAME_CATEGORY CASCADE;


-- liquibase formatted sql

-- changeset micha:1715426246824-1
CREATE TABLE category_listings
(
    category_id BIGINT NOT NULL,
    listings_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-2
CREATE TABLE game_categories
(
    game_id       BIGINT NOT NULL,
    categories_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-3
CREATE TABLE item_photo
(
    item_id  BIGINT NOT NULL,
    photo_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-4
CREATE TABLE transaction_user_entity1items
(
    transaction_id       BIGINT NOT NULL,
    user_entity1items_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-5
CREATE TABLE transaction_user_entity2items
(
    transaction_id       BIGINT NOT NULL,
    user_entity2items_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-6
CREATE TABLE user_entity_ratings_received
(
    user_entity_id      BIGINT NOT NULL,
    ratings_received_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-7
CREATE TABLE user_entity_reports_received
(
    user_entity_id      BIGINT NOT NULL,
    reports_received_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-8
CREATE TABLE user_entity_top_ups
(
    user_entity_id BIGINT NOT NULL,
    top_ups_id     BIGINT NOT NULL
);

-- changeset micha:1715426246824-9
CREATE TABLE user_entity_transactions
(
    user_entity_id  BIGINT NOT NULL,
    transactions_id BIGINT NOT NULL
);

-- changeset micha:1715426246824-10
ALTER TABLE category_listings
    ADD CONSTRAINT uc_category_listings_listings UNIQUE (listings_id);

-- changeset micha:1715426246824-11
ALTER TABLE game_categories
    ADD CONSTRAINT uc_game_categories_categories UNIQUE (categories_id);

-- changeset micha:1715426246824-12
ALTER TABLE item_photo
    ADD CONSTRAINT uc_item_photo_photo UNIQUE (photo_id);

-- changeset micha:1715426246824-13
ALTER TABLE transaction_user_entity1items
    ADD CONSTRAINT uc_transaction_user_entity1items_userentity1items UNIQUE (user_entity1items_id);

-- changeset micha:1715426246824-14
ALTER TABLE transaction_user_entity2items
    ADD CONSTRAINT uc_transaction_user_entity2items_userentity2items UNIQUE (user_entity2items_id);

-- changeset micha:1715426246824-15
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT uc_user_entity_ratings_received_ratingsreceived UNIQUE (ratings_received_id);

-- changeset micha:1715426246824-16
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT uc_user_entity_reports_received_reportsreceived UNIQUE (reports_received_id);

-- changeset micha:1715426246824-17
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT uc_user_entity_top_ups_topups UNIQUE (top_ups_id);

-- changeset micha:1715426246824-18
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT uc_user_entity_transactions_transactions UNIQUE (transactions_id);

-- changeset micha:1715426246824-19
ALTER TABLE category_listings
    ADD CONSTRAINT fk_catlis_on_category FOREIGN KEY (category_id) REFERENCES category (id);

-- changeset micha:1715426246824-20
ALTER TABLE category_listings
    ADD CONSTRAINT fk_catlis_on_listing FOREIGN KEY (listings_id) REFERENCES listing (id);

-- changeset micha:1715426246824-21
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_category FOREIGN KEY (categories_id) REFERENCES category (id);

-- changeset micha:1715426246824-22
ALTER TABLE game_categories
    ADD CONSTRAINT fk_gamcat_on_game FOREIGN KEY (game_id) REFERENCES game (id);

-- changeset micha:1715426246824-23
ALTER TABLE item_photo
    ADD CONSTRAINT fk_itepho_on_item FOREIGN KEY (item_id) REFERENCES item (id);

-- changeset micha:1715426246824-24
ALTER TABLE item_photo
    ADD CONSTRAINT fk_itepho_on_photo FOREIGN KEY (photo_id) REFERENCES photo (id);

-- changeset micha:1715426246824-25
ALTER TABLE transaction_user_entity1items
    ADD CONSTRAINT fk_trauseent_on_item FOREIGN KEY (user_entity1items_id) REFERENCES item (id);

-- changeset micha:1715426246824-26
ALTER TABLE transaction_user_entity2items
    ADD CONSTRAINT fk_trauseent_on_itemEFGiQw FOREIGN KEY (user_entity2items_id) REFERENCES item (id);

-- changeset micha:1715426246824-27
ALTER TABLE transaction_user_entity1items
    ADD CONSTRAINT fk_trauseent_on_transaction FOREIGN KEY (transaction_id) REFERENCES transaction (id);

-- changeset micha:1715426246824-28
ALTER TABLE transaction_user_entity2items
    ADD CONSTRAINT fk_trauseent_on_transactionhzXRs4 FOREIGN KEY (transaction_id) REFERENCES transaction (id);

-- changeset micha:1715426246824-29
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT fk_useentratrec_on_rating FOREIGN KEY (ratings_received_id) REFERENCES rating (id);

-- changeset micha:1715426246824-30
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT fk_useentratrec_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset micha:1715426246824-31
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT fk_useentreprec_on_report FOREIGN KEY (reports_received_id) REFERENCES report (id);

-- changeset micha:1715426246824-32
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT fk_useentreprec_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset micha:1715426246824-33
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT fk_useenttopups_on_top_up FOREIGN KEY (top_ups_id) REFERENCES top_up (id);

-- changeset micha:1715426246824-34
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT fk_useenttopups_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset micha:1715426246824-35
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT fk_useenttra_on_transaction FOREIGN KEY (transactions_id) REFERENCES transaction (id);

-- changeset micha:1715426246824-36
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT fk_useenttra_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);


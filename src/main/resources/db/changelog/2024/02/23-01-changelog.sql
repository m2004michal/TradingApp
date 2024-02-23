-- liquibase formatted sql

-- changeset michaltu:1708687650518-1
CREATE TABLE user_entity_ratings_recived
(
    user_entity_id     BIGINT NOT NULL,
    ratings_recived_id BIGINT NOT NULL
);

-- changeset michaltu:1708687650518-2
CREATE TABLE user_entity_top_ups
(
    user_entity_id BIGINT NOT NULL,
    top_ups_id     BIGINT NOT NULL
);

-- changeset michaltu:1708687650518-3
CREATE TABLE user_entity_transactions
(
    user_entity_id  BIGINT NOT NULL,
    transactions_id BIGINT NOT NULL
);

-- changeset michaltu:1708687650518-4
ALTER TABLE listing
    ADD is_promoted BOOLEAN;
ALTER TABLE listing
    ADD views INT;

-- changeset michaltu:1708687650518-5
ALTER TABLE listing
    ALTER COLUMN is_promoted SET NOT NULL;

-- changeset michaltu:1708687650518-6
ALTER TABLE user_entity
    ADD profile_picture_id BIGINT;

-- changeset michaltu:1708687650518-8
ALTER TABLE listing
    ALTER COLUMN views SET NOT NULL;

-- changeset michaltu:1708687650518-9
ALTER TABLE user_entity_ratings_recived
    ADD CONSTRAINT uc_user_entity_ratings_recived_ratingsrecived UNIQUE (ratings_recived_id);

-- changeset michaltu:1708687650518-10
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT uc_user_entity_top_ups_topups UNIQUE (top_ups_id);

-- changeset michaltu:1708687650518-11
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT uc_user_entity_transactions_transactions UNIQUE (transactions_id);

-- changeset michaltu:1708687650518-12
ALTER TABLE user_entity
    ADD CONSTRAINT FK_USERENTITY_ON_PROFILE_PICTURE FOREIGN KEY (profile_picture_id) REFERENCES photo (id);

-- changeset michaltu:1708687650518-13
ALTER TABLE user_entity_ratings_recived
    ADD CONSTRAINT fk_useentratrec_on_rating FOREIGN KEY (ratings_recived_id) REFERENCES rating (id);

-- changeset michaltu:1708687650518-14
ALTER TABLE user_entity_ratings_recived
    ADD CONSTRAINT fk_useentratrec_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset michaltu:1708687650518-15
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT fk_useenttopups_on_top_up FOREIGN KEY (top_ups_id) REFERENCES top_up (id);

-- changeset michaltu:1708687650518-16
ALTER TABLE user_entity_top_ups
    ADD CONSTRAINT fk_useenttopups_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset michaltu:1708687650518-17
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT fk_useenttra_on_transaction FOREIGN KEY (transactions_id) REFERENCES transaction (id);

-- changeset michaltu:1708687650518-18
ALTER TABLE user_entity_transactions
    ADD CONSTRAINT fk_useenttra_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);


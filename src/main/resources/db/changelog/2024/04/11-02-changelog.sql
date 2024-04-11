-- liquibase formatted sql

-- changeset micha:1712833660694-1
ALTER TABLE user_entity
    ADD is_phone_number_verified BOOLEAN;
ALTER TABLE user_entity
    ADD surname VARCHAR(255);

-- changeset micha:1712833660694-2
ALTER TABLE user_entity
    ALTER COLUMN is_phone_number_verified SET NOT NULL;

-- changeset micha:1712833660694-4
ALTER TABLE USER_ENTITY DROP COLUMN SURENAME;


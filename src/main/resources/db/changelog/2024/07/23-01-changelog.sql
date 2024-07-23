-- liquibase formatted sql

-- changeset micha:1721685706624-4
ALTER TABLE user_entity
    ADD escrow_balance DECIMAL;
ALTER TABLE user_entity
    ADD security_balance DECIMAL;

-- changeset micha:1721685706624-1
ALTER TABLE user_entity DROP COLUMN balance;

-- changeset micha:1721685706624-2
ALTER TABLE user_entity
    ADD balance DECIMAL;

-- changeset micha:1721685706624-3
ALTER TABLE user_entity ALTER COLUMN balance SET NULL;


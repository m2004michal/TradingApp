-- liquibase formatted sql

-- changeset micha:1722517163909-4
ALTER TABLE listing
    ADD quantity INT;

-- changeset micha:1722517163909-5
ALTER TABLE listing
    ALTER COLUMN quantity SET NOT NULL;

-- changeset micha:1722517163909-6
ALTER TABLE LISTING DROP COLUMN AMOUNT;

-- changeset micha:1722517163909-1
ALTER TABLE listing DROP COLUMN price;

-- changeset micha:1722517163909-2
ALTER TABLE listing
    ADD price DECIMAL;

-- changeset micha:1722517163909-3
ALTER TABLE listing ALTER COLUMN price SET NULL;


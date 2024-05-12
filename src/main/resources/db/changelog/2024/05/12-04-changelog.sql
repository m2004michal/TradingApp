-- liquibase formatted sql

-- changeset micha:1715529754339-1
ALTER TABLE listing
    ADD category_id BIGINT;

-- changeset micha:1715529754339-2
ALTER TABLE listing
    ADD CONSTRAINT FK_LISTING_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);


-- liquibase formatted sql

-- changeset micha:1729093283929-4
ALTER TABLE LISTING_PHOTOS DROP CONSTRAINT FK_LISPHO_ON_LISTING;

-- changeset micha:1729093283929-5
ALTER TABLE LISTING_PHOTOS DROP CONSTRAINT FK_LISPHO_ON_PHOTO;

-- changeset micha:1729093283929-1
ALTER TABLE photo
    ADD listing_id BIGINT;

-- changeset micha:1729093283929-2
ALTER TABLE photo
    ALTER COLUMN listing_id SET NOT NULL;

-- changeset micha:1729093283929-3
ALTER TABLE photo
    ADD CONSTRAINT FK_PHOTO_ON_LISTINGID FOREIGN KEY (listing_id) REFERENCES listing (id);

-- changeset micha:1729093283929-7
DROP TABLE LISTING_PHOTOS CASCADE;


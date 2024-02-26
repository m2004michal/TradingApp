-- liquibase formatted sql

-- changeset michaltu:1708980568312-1
ALTER TABLE listing
    ADD url VARCHAR(255);


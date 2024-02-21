-- liquibase formatted sql
-- changeset michaltu:5
ALTER TABLE USERENTITIES
    ADD previouslyUsedPasswords varchar(1000000);

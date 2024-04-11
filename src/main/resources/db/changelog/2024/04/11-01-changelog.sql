-- liquibase formatted sql

-- changeset micha:1712832626818-20
ALTER TABLE RATING DROP CONSTRAINT FK_RATING_ON_RATING_RECIVER;

-- changeset micha:1712832626818-21
ALTER TABLE REPORT DROP CONSTRAINT FK_REPORT_ON_REPORTEDBYUSERENTITY;

-- changeset micha:1712832626818-22
ALTER TABLE REPORT DROP CONSTRAINT FK_REPORT_ON_REPORTEDUSERENTITY;

-- changeset micha:1712832626818-23
ALTER TABLE USER_ENTITY_RATINGS_RECIVED DROP CONSTRAINT FK_USEENTRATREC_ON_RATING;

-- changeset micha:1712832626818-24
ALTER TABLE USER_ENTITY_RATINGS_RECIVED DROP CONSTRAINT FK_USEENTRATREC_ON_USER_ENTITY;

-- changeset micha:1712832626818-25
ALTER TABLE USER_ENTITY_REPORTS_RECIVED DROP CONSTRAINT FK_USEENTREPREC_ON_REPORT;

-- changeset micha:1712832626818-26
ALTER TABLE USER_ENTITY_REPORTS_RECIVED DROP CONSTRAINT FK_USEENTREPREC_ON_USER_ENTITY;

-- changeset micha:1712832626818-1
CREATE TABLE user_entity_ratings_received
(
    user_entity_id      BIGINT NOT NULL,
    ratings_received_id BIGINT NOT NULL
);

-- changeset micha:1712832626818-2
CREATE TABLE user_entity_reports_received
(
    user_entity_id      BIGINT NOT NULL,
    reports_received_id BIGINT NOT NULL
);

-- changeset micha:1712832626818-3
ALTER TABLE user_entity
    ADD previously_used_passwords VARCHAR(255);

-- changeset micha:1712832626818-4
ALTER TABLE rating
    ADD rating_receiver_id BIGINT;

-- changeset micha:1712832626818-5
ALTER TABLE report
    ADD reported_by_id BIGINT;
ALTER TABLE report
    ADD reported_user_id BIGINT;

-- changeset micha:1712832626818-6
ALTER TABLE report
    ALTER COLUMN reported_by_id SET NOT NULL;

-- changeset micha:1712832626818-8
ALTER TABLE report
    ALTER COLUMN reported_user_id SET NOT NULL;

-- changeset micha:1712832626818-9
ALTER TABLE report
    ADD CONSTRAINT uc_report_reported_by UNIQUE (reported_by_id);

-- changeset micha:1712832626818-10
ALTER TABLE report
    ADD CONSTRAINT uc_report_reported_user UNIQUE (reported_user_id);

-- changeset micha:1712832626818-11
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT uc_user_entity_ratings_received_ratingsreceived UNIQUE (ratings_received_id);

-- changeset micha:1712832626818-12
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT uc_user_entity_reports_received_reportsreceived UNIQUE (reports_received_id);

-- changeset micha:1712832626818-13
ALTER TABLE rating
    ADD CONSTRAINT FK_RATING_ON_RATING_RECEIVER FOREIGN KEY (rating_receiver_id) REFERENCES user_entity (id);

-- changeset micha:1712832626818-14
ALTER TABLE report
    ADD CONSTRAINT FK_REPORT_ON_REPORTED_BY FOREIGN KEY (reported_by_id) REFERENCES user_entity (id);

-- changeset micha:1712832626818-15
ALTER TABLE report
    ADD CONSTRAINT FK_REPORT_ON_REPORTED_USER FOREIGN KEY (reported_user_id) REFERENCES user_entity (id);

-- changeset micha:1712832626818-16
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT fk_useentratrec_on_rating FOREIGN KEY (ratings_received_id) REFERENCES rating (id);

-- changeset micha:1712832626818-17
ALTER TABLE user_entity_ratings_received
    ADD CONSTRAINT fk_useentratrec_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset micha:1712832626818-18
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT fk_useentreprec_on_report FOREIGN KEY (reports_received_id) REFERENCES report (id);

-- changeset micha:1712832626818-19
ALTER TABLE user_entity_reports_received
    ADD CONSTRAINT fk_useentreprec_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);

-- changeset micha:1712832626818-31
DROP TABLE USER_ENTITY_RATINGS_RECIVED CASCADE;

-- changeset micha:1712832626818-32
DROP TABLE USER_ENTITY_REPORTS_RECIVED CASCADE;

-- changeset micha:1712832626818-33
ALTER TABLE USER_ENTITY DROP COLUMN PERVIOUSLY_USED_PASSWORDS;

-- changeset micha:1712832626818-34
ALTER TABLE RATING DROP COLUMN RATING_RECIVER_ID;

-- changeset micha:1712832626818-35
ALTER TABLE REPORT DROP COLUMN REPORTED_BY_USER_ENTITY_ID;
ALTER TABLE REPORT DROP COLUMN REPORTED_USER_ENTITY_ID;


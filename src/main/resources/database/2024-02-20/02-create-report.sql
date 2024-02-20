-- liquibase formatted sql
-- changeset michaltu:2
CREATE TABLE reports(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reportedByUserEntity_id BIGINT,
    reportedUserEntity_id BIGINT,
    FOREIGN KEY (reportedByUserEntity_id) REFERENCES userEntities(id),
    FOREIGN KEY (reportedUserEntity_id) REFERENCES userEntities(id),
    message VARCHAR(355) NOT NULL,
    reportCause VARCHAR(20) NOT NULL
)


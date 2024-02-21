-- liquibase formatted sql
-- changeset michaltu:9
CREATE TABLE Photo (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       filePath VARCHAR(255),
                       name VARCHAR(255),
                       item_id BIGINT,
                       FOREIGN KEY (item_id) REFERENCES ITEMS(id)
);
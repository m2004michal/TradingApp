-- liquibase formatted sql
-- changeset michaltu:4
CREATE TABLE Ratings (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               rating INT NOT NULL,
                               opinionMessage TEXT,
                               ratingGiver_id BIGINT,
                               ratingReceiver_id BIGINT,
                               CONSTRAINT fk_ratingGiver
                                   FOREIGN KEY (ratingGiver_id)
                                       REFERENCES USERENTITIES (id),
                               CONSTRAINT fk_ratingReceiver
                                   FOREIGN KEY (ratingReceiver_id)
                                       REFERENCES USERENTITIES (id)
);
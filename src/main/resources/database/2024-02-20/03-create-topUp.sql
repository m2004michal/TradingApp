CREATE TABLE TopUp (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       date TIMESTAMP,
                       userEntity_id BIGINT NOT NULL,
                       amount DOUBLE PRECISION,
                       paymentOption VARCHAR(255),
                       FOREIGN KEY (userEntity_id) REFERENCES USERENTITIES(id)
);
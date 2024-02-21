-- liquibase formatted sql
-- changeset michaltu:8
CREATE TABLE Item (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      tags VARCHAR(255),
                      priceAndDateHistory VARCHAR(100000000),
                      steamMarketId INT,
                      category_id BIGINT,
                      FOREIGN KEY (category_id) REFERENCES CATEGORIES(id)
);
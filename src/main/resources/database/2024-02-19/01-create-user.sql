--liquibase formatted sql
--changeset michaltu:1
CREATE TABLE userEntities (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       phoneNumber VARCHAR(20),
                       balance DOUBLE NOT NULL,
                       name VARCHAR(255),
                       surname VARCHAR(255),
                       createdDate TIMESTAMP NOT NULL,
                       currentFeeFlat DOUBLE NOT NULL,
                       currentFeePercentage DOUBLE NOT NULL,
                       level INT NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       isAccountExpired BOOLEAN NOT NULL,
                       isLocked BOOLEAN NOT NULL,
                       isCredentialsNonExpired BOOLEAN NOT NULL,
                       isEnabled BOOLEAN NOT NULL

);







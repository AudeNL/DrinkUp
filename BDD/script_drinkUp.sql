SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Create User 3A
-- -----------------------------------------------------
DROP USER '3A'@'localhost';
CREATE USER '3A'@'localhost' IDENTIFIED BY 'ensi2016';
GRANT ALL PRIVILEGES ON * . * TO '3A'@'localhost';

-- -----------------------------------------------------
-- Create Database DRINK_UP
-- -----------------------------------------------------
DROP DATABASE IF EXISTS DRINK_UP;
CREATE SCHEMA IF NOT EXISTS DRINK_UP DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE DRINK_UP;

-- -----------------------------------------------------
-- Table DRINK_UP.TYPE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DRINK_UP.TYPE
(
	idType INT NOT NULL,
	nameType VARCHAR(30) NOT NULL,
	PRIMARY KEY (idType)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.PUB
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DRINK_UP.PUB
(
	idPub INT NOT NULL,
	idType INT NOT NULL,
	namePub VARCHAR(45) NOT NULL,
	adress VARCHAR(45) NOT NULL,
	zipCode VARCHAR(10) NOT NULL,
	city VARCHAR(30) NOT NULL,
	xPos FLOAT NOT NULL,
	yPos FLOAT NOT NULL,
	zPos FLOAT NOT NULL,
	PRIMARY KEY (idPub),
	INDEX idx_PUB_TYPE (idType ASC),
	CONSTRAINT fk_PUB_TYPE
    FOREIGN KEY (idType)
		REFERENCES DRINK_UP.TYPE (idType)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.PRODUCT
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DRINK_UP.PRODUCT
(
	idProduct INT NOT NULL,
	idPub INT NOT NULL,
	nameProduct VARCHAR(45) NOT NULL,
	description TEXT NOT NULL,
	price DECIMAL(5,2) NOT NULL,
	PRIMARY KEY (idProduct),
	INDEX idx_PRODUCT_PUB (idPub ASC),
	CONSTRAINT fk_PRODUCT_PUB
    FOREIGN KEY (idPub)
		REFERENCES DRINK_UP.PUB (idPub)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.INGREDIENT
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.INGREDIENT
(
	idIngredient INT NOT NULL,
	nameIngredient VARCHAR(45) NOT NULL,
	PRIMARY KEY (idIngredient)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.CUSTOMER
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.CUSTOMER
(
	idCustomer INT NOT NULL,
	pseudo VARCHAR(10) NOT NULL,
	mail VARCHAR(50) NOT NULL,
	password VARCHAR(8) NOT NULL,
	birthDate DATE NOT NULL,
	PRIMARY KEY (idCustomer)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.COMMENT
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.COMMENT
(
	idComment INT NOT NULL,
	comment TEXT NOT NULL,
	idCustomer INT NOT NULL,
	idProduct INT NOT NULL,
	PRIMARY KEY (idComment),
	INDEX idx_COMMENT_CUSTOMER (idCustomer ASC),
	INDEX idx_COMMENT_PRODUCT (idProduct ASC),
	CONSTRAINT fk_COMMENT_PRODUCT
		FOREIGN KEY (idProduct)
		REFERENCES DRINK_UP.PRODUCT (idProduct)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_COMMENT_CUSTOMER
		FOREIGN KEY (idCustomer)
		REFERENCES DRINK_UP.CUSTOMER (idCustomer)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.ORDER
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.ORDER
(
	idOrder INT NOT NULL,
	idPub INT NOT NULL,
	idCustomer INT NOT NULL,
	orderDate DATETIME NOT NULL,
	price DECIMAL(5,2) NOT NULL,
	status SET('0','1') NOT NULL,
	PRIMARY KEY (idOrder),
	INDEX idx_ORDER_PUB (idPub ASC),
	INDEX idx_ORDER_CUSTOMER (idCustomer ASC),
	CONSTRAINT fk_ORDER_PUB
		FOREIGN KEY (idPub)
		REFERENCES DRINK_UP.PUB (idPub)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_OERDER_CUSTOMER
		FOREIGN KEY (idCustomer)
		REFERENCES DRINK_UP.CUSTOMER (idCustomer)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.ORDER_HISTORY
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.ORDER_HISTORY
(
	idOrderHistory INT NOT NULL,
	idPub INT NOT NULL,
	idCustomer INT NOT NULL,
	PRIMARY KEY (idOrderHistory),
	INDEX idx_CUSTOMER (idCustomer ASC),
	INDEX idx_PUB (idPub ASC),
	CONSTRAINT fk_ORDER_HISTORY_PUB
		FOREIGN KEY (idPub)
		REFERENCES DRINK_UP.PUB (idPub)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_ORDER_HISTORY_CUSTOMER
		FOREIGN KEY (idCustomer)
		REFERENCES DRINK_UP.CUSTOMER (idCustomer)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.ORDER_PRODUCT
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.ORDER_PRODUCT
(
	idProduct INT NOT NULL,
	idOrder INT NOT NULL,
	quantity TINYINT NOT NULL,
	PRIMARY KEY (idProduct, idOrder),
	INDEX idx_ORDER_PRODUCT_PRODUCT (idProduct ASC),
	INDEX idx_ORDER_PRODUCT_ORDER (idOrder ASC),
	CONSTRAINT fk_ORDER_PRODUCT_PRODUCT
		FOREIGN KEY (idProduct)
		REFERENCES DRINK_UP.PRODUCT (idProduct)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_ORDER_PRODUCT_ORDER
		FOREIGN KEY (idOrder)
		REFERENCES DRINK_UP.ORDER (idOrder)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table DRINK_UP.PRODUCT_INGREDIENT
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS DRINK_UP.PRODUCT_INGREDIENT
(
	idProduct INT NOT NULL,
	idIngredient INT NOT NULL,
	PRIMARY KEY (idProduct, idIngredient),
	INDEX idx_PRODUCT_INGREDIENTPRODUCT_ (idProduct ASC),
	INDEX idx_PRODUCT_INGREDIENT_INGREDIENT (idIngredient ASC),
	CONSTRAINT fk_PRODUCT_INGREDIENT_PRODUCT
		FOREIGN KEY (idProduct)
		REFERENCES DRINK_UP.PRODUCT (idProduct)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT fk_PRODUCT_INGREDIENT_INGREDIENT
		FOREIGN KEY (idIngredient)
		REFERENCES DRINK_UP.INGREDIENT (idIngredient)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
ENGINE = InnoDB;

USE DRINK_UP ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

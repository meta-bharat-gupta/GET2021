-- drop database if already exist
DROP DATABASE storefront;
-- create new database
CREATE DATABASE storefront;
-- use database
USE storefront;

-- creating tables for storefront
CREATE TABLE user(
userId INT PRIMARY KEY,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50),
email VARCHAR(50) NOT NULL UNIQUE,
password varchar(50) NOT NULL,
mobile VARCHAR(12),
role varchar(20)
);

CREATE TABLE address(
addressid INT PRIMARY KEY,
userId INT NOT NULL,
area VARCHAR(50),
city VARCHAR(20),
state VARCHAR(20),
pin INT,
FOREIGN KEY (userId) REFERENCES user (userId)
);

CREATE TABLE products(
productId INT PRIMARY KEY,
productName VARCHAR(50),
description VARCHAR(100),
price INT,
quantity INT,
status VARCHAR(20),
date DATETIME
);

CREATE TABLE productImages(
imageId INT PRIMARY KEY,
productId INT,
path VARCHAR(500),
FOREIGN KEY (productId) REFERENCES products (productId)
);

CREATE TABLE category(
cid INT PRIMARY KEY,
cname VARCHAR(20),
parentId INT,
FOREIGN KEY (parentId) REFERENCES category (cid)
);

CREATE TABLE productCategory(
productId INT NOT NULL,
categoryId INT NOT NULL,
PRIMARY KEY(productId, categoryId),
FOREIGN KEY (productId) REFERENCES products (productId),
FOREIGN KEY (categoryId) REFERENCES category (cid)
);


CREATE TABLE orders(
orderId INT PRIMARY KEY,
userId INT NOT NULL,
totalAmount DECIMAL,
date DATETIME,
status VARCHAR(20),
FOREIGN KEY (userId) REFERENCES user(userId)
);

CREATE TABLE orderDetails(
orderId INT NOT NULL,
productId INT NOT NULL,
quantity INT NOT NULL,
status VARCHAR(20),
PRIMARY KEY(orderId, productId),
FOREIGN KEY (orderId) REFERENCES orders(orderId),
FOREIGN KEY (productId) REFERENCES products(productId)
);


show tables;

-- disabling foreign key checking constraints 
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE products;
-- enabling foregin key checking constraints
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE products(
productId INT PRIMARY KEY,
productName VARCHAR(50),
description VARCHAR(100),
price INT,
quantity INT,
status VARCHAR(20),
date DATETIME
);


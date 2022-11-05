/*Drop DB*/
DROP DATABASE `college-fest`;

/*Creating DB*/
CREATE DATABASE IF NOT EXISTS `college-fest`;

/*Using DB*/
USE `college-fest`;

/*Creating students table*/
CREATE TABLE IF NOT EXISTS students(
id int primary key NOT NULL AUTO_INCREMENT,
first_name varchar(255) NOT NULL,
last_name varchar(255) NOT NULL,
department varchar(255),
country varchar(255) NOT NULL
);

/*Inserting into students table*/
INSERT INTO students(first_name, last_name, department, country) VALUES("Suresh", "Reddy", "B.Tech", 'India');
INSERT INTO students(first_name, last_name, department, country) VALUES("Muri", "Mohan", "B.Arch", 'Canada');
INSERT INTO students(first_name, last_name, department, country) VALUES("Daniel", "Denson", "B.Tech", 'New Zealand');
INSERT INTO students(first_name, last_name, department, country) VALUES("Tanya", "Gupta", "B.Com", 'USA');

/*Creating roles table*/
CREATE TABLE IF NOT EXISTS roles(
role_id int primary key NOT NULL AUTO_INCREMENT,
role_name varchar(255) NOT NULL
);

/*Inserting into roles table*/
INSERT INTO roles(role_name) VALUES("USER");
INSERT INTO roles(role_name) VALUES("ADMIN");

/*Creating users table*/
CREATE TABLE IF NOT EXISTS users(
user_id int primary key NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
password varchar(255) NOT NULL,
email_address varchar(255)
);

/*Inserting into users table*/
INSERT INTO users(username, password, email_address) VALUES("user","$2a$10$K3Z7yYTcL2p7gx.DOzQffOOFA6mwJevET25vKOyFkEGdsPrqEHAHa","user@gmail.com");
INSERT INTO users(username, password, email_address) VALUES("admin","$2a$10$yGpvt/NpoumNrISx60Yd/.zEMgcaYK5r/sP1MolNJdn8i8Au6FPoq","admin@gmail.com");

/*Creating users_roles table*/
CREATE TABLE IF NOT EXISTS users_roles(
user_id int NOT NULL,
role_id int NOT NULL,
primary key (user_id, role_id),
FOREIGN KEY (user_id)
      REFERENCES users(user_id)
      ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY (role_id)
      REFERENCES roles(role_id)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

/*Inserting into users_roles table*/
INSERT INTO users_roles(user_id, role_id) VALUES(1,1);
INSERT INTO users_roles(user_id, role_id) VALUES(2,2);
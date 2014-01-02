DROP DATABASE IF EXISTS SpringLearning_SpringJdbc;
CREATE DATABASE `SpringLearning_SpringJdbc` DEFAULT CHARACTER SET 'UTF8' COLLATE 'utf8_general_ci';

CREATE TABLE `SpringLearning_SpringJdbc`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `group_id` INT NOT NULL ,
  `first_name` VARCHAR (32) NOT NULL ,
  `last_name` VARCHAR (32) NOT NULL ,
  `age` FLOAT(5,2) DEFAULT '18.2',
   UNIQUE UQ_NAME (first_name, last_name),

   CONSTRAINT FK_GROUP FOREIGN KEY (group_id) REFERENCES `Group`(`id`)
);

CREATE TABLE `SpringLearning_SpringJdbc`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR(255) NOT NULL ,
  `created_at` DATE,
  UNIQUE UQ_NAME (name)
);
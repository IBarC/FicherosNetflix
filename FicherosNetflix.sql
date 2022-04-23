create database if not exists FicherosNetflix;
use FicherosNetflix;

CREATE TABLE if not exists `ficherosnetflix`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

ALTER TABLE `ficherosnetflix`.`users` 
ADD COLUMN `email` VARCHAR(60) NOT NULL AFTER `password`,
CHANGE COLUMN `id` `id` INT NULL ,
CHANGE COLUMN `username` `username` VARCHAR(45) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`email`, `username`),
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;
;
delete from users;
select * from users;

ALTER TABLE `ficherosnetflix`.`users` 
CHANGE COLUMN `password` `password` VARCHAR(255) NULL DEFAULT NULL ;

ALTER TABLE `ficherosnetflix`.`users` 
CHANGE COLUMN `id` `id` VARCHAR(5) NULL DEFAULT NULL ;

ALTER TABLE `ficherosnetflix`.`users` 
DROP COLUMN `username`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`email`),
DROP INDEX `username_UNIQUE` ;

CREATE TABLE `ficherosnetflix`.`shows` (
  `show_id` VARCHAR(10) NOT NULL,
  `type` VARCHAR(45) NULL,
  `title` VARCHAR(255) NULL,
  `director` VARCHAR(45) NULL,
  `cast` VARCHAR(255) NULL,
  `country` VARCHAR(45) NULL,
  `date_added` VARCHAR(45) NULL,
  `release_year` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  `duration` VARCHAR(45) NULL,
  `listed_in` VARCHAR(255) NULL,
  `description` LONGTEXT NULL,
  PRIMARY KEY (`show_id`));

select * from shows;
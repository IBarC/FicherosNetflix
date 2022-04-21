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

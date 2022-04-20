create database if not exists FicherosNetflix;
use FicherosNetflix;

CREATE TABLE if not exists `ficherosnetflix`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

insert into users(id, username, password)
values (
1, "a", "a");

select * from users;
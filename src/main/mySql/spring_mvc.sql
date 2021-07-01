/*DROP TABLE `spring-mvc`.`t_products`; 
*/

CREATE SCHEMA `spring-mvc` ;


CREATE TABLE `spring-mvc`.`t_products` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NULL,
  `Cost` INT UNSIGNED ZEROFILL NULL DEFAULT 0,
  `Description` VARCHAR(45) ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
COMMENT = 'Создать таблицу products с полями id, title, cost и скрипт инициализацию с 5-10 разными позициями';



insert into  `spring-mvc`.t_products (Title,Cost)  VALUES ("BMW_X1",'1001'),
						          ("BMW_X2",'1002'),
							  ("BMW_X3",'1003'),
							  ("BMW_X4",'1004'),
							  ("VW_1",'1101'),
							  ("VW_2",'1102'),
							  ("VW_3",'1103'),
							  ("VW_4",'1104'),;



CREATE DATABASE springbootdb;

DROP TABLE IF EXISTS 'springbootdb';

CREATE TABLE `city` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '城市编号',
    `province_id` INT(10) UNSIGNED NOT NULL COMMENT '省份编号',
    `city_name` VARCHAR(25) DEFAULT NULL COMMENT '城市编号',
    `description` VARCHAR(25) DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
    ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT city VALUES (1,1, '咸阳市', 'My Home is in Wugong!');
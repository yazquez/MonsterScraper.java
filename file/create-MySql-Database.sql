CREATE SCHEMA `monster`;

CREATE TABLE `monster`.`launchs` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Date` DATETIME NULL,
  `Host` VARCHAR(45) NULL,
  `Configuration` VARCHAR(255) NULL,
  PRIMARY KEY (`Id`)) DEFAULT CHARSET=utf8;


CREATE TABLE `monster`.`results` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Technology` varchar(45) DEFAULT NULL,
  `Occurences` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)) DEFAULT CHARSET=utf8;
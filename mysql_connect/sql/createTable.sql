
ALTER TABLE `dev_db`.`tb_user` 
CHANGE COLUMN `USER_ID` `USER_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'userId' ,
ADD UNIQUE INDEX `USER_ID_UNIQUE` (`USER_ID` ASC);


CREATE TABLE `tb_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userId',
  `USER_NM` varchar(45) DEFAULT NULL COMMENT 'user name',
  `USER_ADDR` varchar(120) DEFAULT NULL COMMENT 'address\n',
  `USER_EMAIL` varchar(80) DEFAULT NULL COMMENT 'email',
  `USER_TYPE` int(1) DEFAULT '1' COMMENT '1:man 2:woman',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_ID_UNIQUE` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;



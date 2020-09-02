CREATE TABLE IF NOT EXISTS `todo_list`.`todos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(45) NOT NULL,
  `done` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;



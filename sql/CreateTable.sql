drop DATABASE if exists workdb;

create DATABASE workdb default CHARACTER SET = UTF8;

DROP TABLE IF EXISTS `workdb`.`hfstm`;
CREATE TABLE  `workdb`.`hfstm` (
  `year`  varchar(8) NOT NULL,
  `month` varchar(2) NOT NULL,
  `jamt`  INT NOT NULL,
  `kbamt` INT NOT NULL,
  `wramt` INT NOT NULL,
  `shamt` INT NOT NULL,
  `ctamt` INT NOT NULL,
  `hnamt` INT NOT NULL,
  `nhamt` INT NOT NULL,
  `examt` INT NOT NULL,
  `etcamt` INT NOT NULL,
  
  PRIMARY KEY (`year`, `month`)
) 
;


commit;


;


drop DATABASE if exists workdb;

create DATABASE workdb default CHARACTER SET = UTF8;

DROP TABLE IF EXISTS `workdb`.`noticeboard`;
CREATE TABLE  `workdb`.`hfstm` (
  `year`  varchar(4) NOT NULL,
  `month` varchar(2) NOT NULL,
  `j_amt` varchar(45)   NULL,
  `kb_amt` varchar(45)  NULL,
  `wr_amt` varchar(45)  NULL,
  `sh_amt` varchar(45)  NULL,
  `ct_amt` varchar(45)  NULL,
  `hn_amt` varchar(45)  NULL,
  `nh_amt` varchar(45)  NULL,
  `ex_amt` varchar(45)  NULL,
  `etc_amt` varchar(45)  NULL,
  
  
  PRIMARY KEY (`year`, `month`)
) 
;


commit;


;


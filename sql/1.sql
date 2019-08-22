select *
from hfstm
;

delete from hfstm
;

commit;

;


select year, month, jamt, kbamt, wramt, shamt, ctamt, hnamt, nhamt, examt, etcamt
       from hfstm
       
       ;
       select 
       MAX(AMT)
       from (
       select 
       year,
 	   sum(CASE
            '8'
       WHEN '1' THEN jamt
       WHEN '2' THEN kbamt
       WHEN '3' THEN wramt
       WHEN '4' THEN shamt
       WHEN '5' THEN ctamt
       WHEN '6' THEN hnamt
       WHEN '7' THEN nhamt
       WHEN '8' THEN examt
       WHEN '9'THEN etcamt
       end
       ) as amt
       from hfstm
       where 1=1
       group by year
       ) T1
       GROUP BY YEAR
       ;
       
       
       SELECT  MAX(AMT)
       FROM (
       select 
       year,
 
       (
 	   CASE
            '8'
       WHEN '1' THEN sum(jamt)
       WHEN '2' THEN sum(kbamt)
       WHEN '3' THEN sum(wramt)
       WHEN '4' THEN sum(shamt)
       WHEN '5' THEN sum(ctamt)
       WHEN '6' THEN sum(hnamt)
       WHEN '7' THEN sum(nhamt)
       WHEN '8' THEN sum(examt)
       WHEN '9'THEN sum(etcamt)
       end
       ) AS AMT
     
       from hfstm
       where 1=1
       group by year
       ) T1
      
 ;
 
 
 
 	   select 
       year,
 	   sum(CASE
            '8'
       WHEN '1' THEN jamt
       WHEN '2' THEN kbamt
       WHEN '3' THEN wramt
       WHEN '4' THEN shamt
       WHEN '5' THEN ctamt
       WHEN '6' THEN hnamt
       WHEN '7' THEN nhamt
       WHEN '8' THEN examt
       WHEN '9'THEN etcamt
       end
       ) as amt
       from hfstm
       where 1=1
       group by year
       ;
       
       
        select 
       year,
 	   sum(jamt) as jamt,
 	   sum(kbamt) as kbamt,
 	   sum(wramt) as wramt,
 	   sum(shamt) as shamt,
 	   sum(ctamt) as ctamt,
 	   sum(hnamt) as hnamt,
 	   sum(nhamt) as nhamt,
 	   sum(examt) as examt,
 	   sum(etcamt) as etcamt,
 	   sum(jamt+kbamt+wramt+shamt+ctamt+hnamt+nhamt+examt+etcamt) as sumamt
       from hfstm
       where 1=1
       group by year;
       
       
         select 
         year,
       sum(jamt) jamt,
       sum(kbamt) kbamt,
       sum(wramt) wramt,
       sum(shamt) shamt,
       sum(ctamt) ctamt,
       sum(hnamt) hnamt,
       sum(nhamt) nhamt,
       sum(examt) examt,
       sum(etcamt) etcamt
       from hfstm
       group by year
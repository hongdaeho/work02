package org.hfs.dao;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;

import org.hfs.domain.HfsVO;
import org.hfs.domain.HfsVO2;
import org.hfs.domain.HfsVO3;

public interface HfsDAO {

    public void insertHfs(HfsVO vo);
 
    public List<HfsVO> selectHfs();
  
    public List<HfsVO> selectHfs001(); 
    
    public List<HfsVO3> selectHfs002(String bankCd); 

    public List<HfsVO>  selectHfs003();
    
}

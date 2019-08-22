package org.hfs.dao;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hfs.domain.HfsVO;
import org.hfs.domain.HfsVO2;
import org.hfs.domain.HfsVO3;
import org.springframework.stereotype.Repository;

@Repository //DAO라고 명시 (DAO를 스프링에서 인식시켜줌)
public class HfsDAOImpl implements HfsDAO { 

    @Inject // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
    private SqlSession sqlSession; 
    
    
    private static final String namespace = "org.hfs.mapper.HfsMapper"; 
                                            //memberMapper.xml의 namespace값 


	private static final int List = 0;
    
    @Override
    public void insertHfs(HfsVO vo) {
        sqlSession.insert(namespace+".insertHfs", vo);
    }
    
    @Override
    public List<HfsVO> selectHfs() { 
    	List<HfsVO> hv = sqlSession.selectList(namespace+".selectHfs");
		return hv; 
    }
    
    
    @Override
    public List<HfsVO> selectHfs001() { 
    	List<HfsVO> hv = sqlSession.selectList(namespace+".selectHfs001");
		return hv; 
    }
    
    @Override
    public List<HfsVO3> selectHfs002(String bankCd) { 
       
		return sqlSession.selectList(namespace+".selectHfs002", bankCd); 
    }
    
    @Override
    public List<HfsVO> selectHfs003() { 
       
		return sqlSession.selectList(namespace+".selectHfs003"); 
    }
    
}


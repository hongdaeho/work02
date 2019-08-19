package org.hfs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.hfs.domain.hfsVO;
import org.springframework.stereotype.Repository;

@Repository //DAO라고 명시 (DAO를 스프링에서 인식시켜줌)
public class HfsDAOImp implements HfsDAO { 

    @Inject // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
    private SqlSession sqlSession; 
    
    
    private static final String namespace = "org.hfs.mapper.MemberMapper"; 
                                            //memberMapper.xml의 namespace값
    
    @Override
    public void insertHfs(hfsVO vo) {
        sqlSession.insert(namespace+".insertHfs", vo);
    }
    
}


package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository  //dao(=repository) 라고 지정 해줌
public class MemberDAO {
    
	@Autowired //의존성 주입//getSession 과 같은 역할 
	private SqlSessionTemplate sqlSession;
	
	 // 위에서 sqlSession이 있기 때문에 서비스때 처럼 sqlSession 받아오지 않아도 됨
    public int registerMember(Member vo) {
			return sqlSession.insert("memberMapper.registerMember", vo);
    }
		
	
	
	public Member login(Member vo) {
		return sqlSession.selectOne("memberMapper.login", vo);
	}
	
	public List<Member> showAllMember(){
		return sqlSession.selectList("memberMapper.showAllMember");
	}
	
	public List<Member> findMember(String keyword){
		return sqlSession.selectList("memberMapper.findMember", keyword );
	}
	
	public int updateMember(Member vo) {
		return sqlSession.update("memberMapper.updateMember", vo);
	}
	                        
	/*
	 * showAllMember
	 * findMember -> 파라미터 : String keyword, return : List<Member>
	 * login  -> 파라미터 : Member vo
	 * updateMember -> 파라미터 : Member vo
	 * */
}

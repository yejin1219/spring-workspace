package com.kh.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	public int insert(Board board) {
		return session.insert("board.insert",board);
	}
	
	public List<Board> selectAll() {
		return session.selectList("board.selectAll");
	}
	
	public  Board select() {
		return session.selectOne(null);
	}
	
//	public int update(Board board) {
//		return sqlSession.update(board);
//	}
	
	
}

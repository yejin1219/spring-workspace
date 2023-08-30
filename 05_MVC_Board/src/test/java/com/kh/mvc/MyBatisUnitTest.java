package com.kh.mvc;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.mvc.model.vo.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisUnitTest {

	//마이바티스 단위 테스트 먼저 하고 넘어가기
	public SqlSession getSession() {
	try {
		Reader r = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		return factory.openSession();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
        return null;
	}
	
	
	@Test
	public void insertTest() {
		SqlSession session = getSession();
		
		Board board = new Board();
		board.setTitle("테스트 06");
		board.setContent("지존이 되는 법");
		board.setWriter("김예진");
		System.out.println("db before :: " + board.getNo());
		
		int result = session.insert("board.insert", board);
		
		if(result>0) {
			System.out.println(result + "개 게시글 추가");
			session.commit();
		}
		System.out.println("do after :: " + board.getNo());
		
		System.out.println("===========================================================================");
	}
	
	@Test
	public void selectAll() {
		SqlSession session = getSession();
		List<Board> list = session.selectList("board.selectAll");
		System.out.println(list);
		System.out.println(list.size());
		System.out.println("===========================================================================");
	}
	
}

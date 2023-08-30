package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public int insert(Board board) {
		return dao.insert(board);
	}
	
	public List<Board> selectAll(){
		return dao.selectAll();
	}
	
//	public int update(Board board) {
//		return dao.update(board);
//	}
}

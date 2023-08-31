package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*") // 공통으로 들어가는 경로 뺌
public class BoardController {

	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list( Criteria cri,Model model) {
		List<Board> list = service.selectAll(cri);
		model.addAttribute("list",list);
		//return "board/list"; <- public String list(Model model) 이었는데 , 같은 화면으로 처리하는 거라 void로 바꾸고 return 없앰
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	
	@GetMapping("/insert")// 게시글 등록 버튼을 눌러서 페이지 이동
	public void insert() {}
	
	@PostMapping("/insert") // 게시글 등록하는 순간
	public String insert(Board board) {
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/view")
	public void view(int no, Model model) {
	  Board board = service.selectBoard(no);
	    model.addAttribute("board",board);
	    
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		service.updateBoard(board);
		return "redirect:/board/view?no="+board.getNo();
	}
	
	@GetMapping("delete")
	public String delete(int no) {
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
}


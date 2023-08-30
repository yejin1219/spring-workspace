package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*") // 공통으로 들어가는 경로 뺌
public class BoardController {

	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list",list);
		//return "board/list";
	}
	
//	@PostMapping("/list")
//	
//	@PutMapping
//	
//	@DeleteMapping
//	
	@RequestMapping("/insert")
	public void insert() {
		
	}
	
	
}
package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	
	   @Autowired
       private MemberService service;
	
	   @Autowired
	   private BCryptPasswordEncoder bcpe;
	
	    @GetMapping("/login")
	    public void login() {}
	    
	    
	    @GetMapping("/register")
	    public void register() {}
	    
	    @PostMapping("/register")
	    public String register(Member vo) {
	    	String encodePassword = bcpe.encode(vo.getPassword());
	    	vo.setPassword(encodePassword);
	    	
	    	service.register(vo);
			return "redirect:/login";
	    	
	    }
	    
	    @GetMapping("/logout") //logout.jsp와 로그아웃이 들어가 있는 list.jsp 둘 다 같은 폴더 안에 들어가 있기 때문에 /board/logout 이라고 안써도 됨
	    public void logout() {}
}

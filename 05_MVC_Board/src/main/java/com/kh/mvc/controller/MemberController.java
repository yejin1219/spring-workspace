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
}

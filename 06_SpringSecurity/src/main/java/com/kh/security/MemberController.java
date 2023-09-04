package com.kh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.service.MemberService;
import com.kh.security.model.vo.Member;

@Controller
public class MemberController {

	    @Autowired
	    private MemberService service;
	    
	    @Autowired
	    private BCryptPasswordEncoder bcpe;
	
	    @GetMapping("/all") // 로그인 상관없이 모두들
	    public void all() {}
	    
	    @GetMapping("/member") // 로그인 한 사용자들
	    public void member() {}
	    
	    @GetMapping("/admin") // 관리자만 들어올 수 있는 것
	    public void admin() {}
	    
	    @GetMapping("/login")
	    public void login() {}
	    
	    @GetMapping("/logout")
	    public void logout() {}
	    
	    @GetMapping("/error")
	    public void error() {}
	    
	    @GetMapping("/register")
	    public void register() {}
	    
	    @PostMapping("/register")
	    public String register(Member vo) {
	    	
	    	System.out.println("before password : " + vo.getPassword());
	    	
	    	// BCryptPasswordEncoder를 이용해서 암호화 처리 
	        String encodePassword = bcpe.encode(vo.getPassword());
	        System.out.println("after password : " + encodePassword);
	        
	        vo.setPassword(encodePassword);
	    	
	    	service.registerMember(vo);
	    	return "redirect:/login";
	    }
	    
	    
}

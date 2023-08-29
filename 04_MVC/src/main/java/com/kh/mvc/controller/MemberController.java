package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

//component에 해당 

@Controller
public class MemberController {
   @Autowired
	private MemberService service;
   
   @RequestMapping("search")
   public String search() {
	   return "search";
   }
   
   @RequestMapping("find")
   public String find(String keyword, Model model) {
	   //System.out.println(keyword);
	   // 서비스 - 비즈니스 로직 처리
	   // --> list 값! 데이터 바인딩 -> Model
	   //model.addAttribute("list",list);
	   List list = service.findMember(keyword);
	   model.addAttribute("list",list);
	   if(list != null) {
		   return "find_ok";  
	   } 
	   
	   return "find_fail";  // "find_fail"
   }
   
   @RequestMapping("register")
   public String register() {
	   return "register";
   }
   
   @RequestMapping("signUp")
   public String signUp(Member member) {
	  
	  // System.out.println(member); //-> Member(id=user1, pwd=1111, name=진, addr=서울 강남)
	   // 비즈니스 로직, 위에 member이용
	   Member vo = new Member(
			   member.getId(), member.getName(), member.getPwd(),
			   member.getAddr());
	   
	       int result =  service.registerMember(vo);
	         
	       if(result > 0) return "redirect:/";  // 바인딩 안하고 index.jsp로 넘길때
   }
   
   
   // login - 페이지 이동
   @RequestMapping("login")
   public String login() {
     
	   return "login";
   }
   
  
   
   // signIn - 비즈니스 로직 포함 : 파라미터 값 -> HttpServletRequest request
   // -> return "login_result"
   @RequestMapping("signIn")
   public String signIn(HttpServletRequest request) {
	   String id = request.getParameter("id");
	   String password = request.getParameter("password");
	   Member m = new Member();
	   m.setId(id);
	   m.setPassword(password);
	   
	   Member vo = service.login(m);
	   
	   HttpSession session = request.getSession();
	   
	   if(vo!=null) {
		   session.setAttribute("vo",vo);
	   }
	   
	        
	return "login_result";
	   
   }
   
   @RequestMapping("allMember")
   public String allMember(Model model) {
	   List list = service.showAllMember();
	   // allMember - 비즈니스 로직 포함, 데이터바인딩 - Model
	   // --> return "find_ok";
	   model.addAttribute("list", list);
	return "find_ok";
	   
   }
  
   
   // logout - 로그아웃 기능!
   
   // update - 페이지 이동
   @RequestMapping("update")
   public String update() {
	   return "update";
   }
   
   @RequestMapping("modify")
   public String updateMember(HttpServletRequest request) {
	   String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
	   
	   Member vo = new Member(id,password,name,address);
	   int result = service.updateMember(vo);
	   if(result > 0) return "update_result.jsp";
	
	   
   }
   
   // updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
}

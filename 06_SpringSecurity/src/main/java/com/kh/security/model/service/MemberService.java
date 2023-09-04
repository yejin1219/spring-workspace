package com.kh.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.MemberDAO;
import com.kh.security.model.vo.Member;

@Service
public class MemberService implements UserDetailsService{

	
	 @Autowired
	 private MemberDAO dao;
	 
	 public int registerMember(Member vo) {
		 return dao.registerMember(vo);
	 }

	@Override                      // login.jsp에서 로그인 하는 순간 name="username"을 가져온다.  Member클래스에서 username은 id랑 일치시켜놓았음 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = dao.getMemberById(username);  
		if(member==null) {
			// 일부러 에러 발생 시킴
			throw new UsernameNotFoundException("username" + username + "not found");
		}
		return member;
	}
}

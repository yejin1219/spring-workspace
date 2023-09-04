package com.kh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
                                //  인증 성공 이벤트를 처리하는 인터페이스
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	
	
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleList = new ArrayList(); //getAuthorities  접근 허가 , authentication.getAuthorities() 리턴값 collection
		authentication.getAuthorities().forEach(auth -> {
			System.out.println("auth : " + auth); // member로 로그인한 경우 auth : ROLE_MEMBER , auth : ROLE_ADMIN
			roleList.add(auth.getAuthority());
		});
		
		if(roleList.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}
		
		if(roleList.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		}
		
		response.sendRedirect("/all");
		
	}

}

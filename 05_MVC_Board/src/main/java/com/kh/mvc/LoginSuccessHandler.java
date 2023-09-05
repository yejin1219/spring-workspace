package com.kh.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.mvc.model.vo.Member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override     //onAuthenticationSuccess : 로그인 성공시 호출되는 메소드 
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
/*
		HttpSession session = request.getSession();
		Member member = null;
		if (authentication.getPrincipal() instanceof Member) {
			member = (Member) authentication.getPrincipal();
		}

		// 로그인 한 정보를 session 에 저장했기 때문에 나중에 view.jsp에서 property="principal" 로 로그인한 사용자 정보에 접근할 수 있는 것이다. 
		session.setAttribute("Info", member);
*/
		response.sendRedirect("/board/list");

	}

}

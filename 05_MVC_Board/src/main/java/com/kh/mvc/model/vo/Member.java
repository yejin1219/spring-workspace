package com.kh.mvc.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data                       // UserDetails : 암호화와 권한 하기 위해 받아오는 것 
public class Member implements UserDetails{
      private String id;
      private String password;
      private String name;
      private String address;
      private String auth;
      private int enabled;
      
      //getAuthorities : 회원의 auth(role) 정보 getter
      
      
      
      
      
      
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority(auth));
		return authList; // 권한 리스트 반환 
	}
	@Override
	public String getUsername() { // security는 프라이머리키를 username으로 지정 
		return id; // username과 id 일치 시키기
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled==1 ? true : false;
	}
}

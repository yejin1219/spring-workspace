package com.kh.di;

import lombok.Data;

//lombok : 게터 세터, 빈 생성자 투 스트링 등 자동 생성 해주는 역할 
@Data
public class Hello {

	private String message = "Hello~ ";
	
	public Hello() {
		System.out.println(getClass().getName()+"Instance Create..");
//		getClass().getName() : 클래스 명을 가져온다. 
	}
	
	public void printMessage() {
		System.out.println(getClass().getName() + "=>" + message);
		
	}
	
}

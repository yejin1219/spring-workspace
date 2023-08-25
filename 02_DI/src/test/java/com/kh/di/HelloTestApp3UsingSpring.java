package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTestApp3UsingSpring {

	public static void main(String[] args) {
		//1. BeanFactory 생성.. 주문서는 공장에서 미리 받아서 읽기
		// 주문서 만들기 : Bean Confoguration File : 빈(Bean)설정 문서
		System.out.println("1. BeanFactory 생성..");
		
		//이젠 HelloFactory 만들 필요 없이 만들어져 잇는 BeanFactory 이용
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/hello.xml"));
		

		// 2. getBean()으로 빈을 받아와서 printMessage() 호출
		System.out.println("2.getBean() 클라이언트 호출...");
		Hello hello = (Hello)factory.getBean("hello");   //"hello" 는 hello.xml에서 설정한 id
		hello.printMessage();
	}

}

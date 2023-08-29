package com.kh.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTest {
	
	// onMethod_ 를 씀으로써 다른 어노테이션(속성)을 쓸 수 있음 
	@Setter(onMethod_ = @Autowired)    // @Autowired : SampleService 클래스를 스프링에 Bean으로 자동으로 주입되도록 도와주는 역할(해당 클래스에 @component를 설정해야 스프링의 빈으로 등록 가능 )  
	private SampleService service;
	
	@Test
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}

	@Test
	public void testAdd() throws Exception{
		log.info(service.doAdd("123", "456"));
	}
	
//	@Test
//	public void testAddError() throws Exception{
//		
//		log.info(service.doAdd("123", "ABC"));
//	}
}

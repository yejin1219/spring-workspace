package com.kh.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j // 로깅의 라이브러리 
@Component // 스프링 빈에 등록하는 역할 
public class LogAspect {
    
	@Before("execution(* com.kh.service.SampleService*.*(..)))") // before는 "execution"라고 지정해주는 형태
	  // @Before 어드바이스: 지정한 포인트컷(메서드 실행 시점) 전에 실행될 코드를 정의합니다.
      // execution(* com.kh.service.SampleService*.*(..)))는 패키지 com.kh.service 내의
      // 클래스명이 SampleService로 시작하는 모든 메서드에 대한 실행을 가리킵니다.
	public void logBefore() {
		log.info("===============");
		// 로그의 정보가 정상적으로 출력되면  ("===============") 안의 내용이 출력된다. 
	}
	
	@Before("execution(* com.kh.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	       // 메서드명이 doAdd이고 타입이 String이고 변수명이 str1, str2 로 일치해야 한다.
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 : " + str1);
		log.info("str2 : " + str2);
	}
	
	@AfterThrowing(pointcut="execution(* com.kh.service.SampleService*.*(..))", throwing="exception") // 예외지정 : 언제 던질거냐? exception일 때 던진다..
    public void logException(Exception exception) {
		log.info("Exception..!");
		log.info("exception : " + exception);
	}
	
	@Around("execution(* com.kh.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint joinpoint) {
		long start = System.currentTimeMillis();
		
		log.info("Target : " + joinpoint.getTarget());
		log.info("Param : " + Arrays.toString(joinpoint.getArgs()));
		
		Object result = null;
		
		try {
			result = joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("TIME : " + (end - start) + "ms");
		
		return result;
		
		
	}
}

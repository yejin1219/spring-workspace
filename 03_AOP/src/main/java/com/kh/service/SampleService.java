package com.kh.service;

import org.springframework.stereotype.Service;

@Service // 이 서비스 안에 @component 가 포함되어 잇음 
public class SampleService {
	// int가 아닌 Integer을 쓰는 이유 :  int는 0을 반환하지만  Integer는  null을 반환하여 null 조건처리를 할 수 있음 
    public Integer doAdd(String str1, String str2) throws Exception{
    	
    	return Integer.parseInt(str1) + Integer.parseInt(str2);
    }
}

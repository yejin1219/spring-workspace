package com.kh.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Person;

/*
 * REST (Representational State Transfer)
 * - 하나의 URI 는 하나의 고유한 리소스(Resource)를 대표하도록 설계하는 전송방식
 * - 가장 기억해야 할 점은 서버에서 데이터 자체를 전송하는 방식으로 처리한다는 것!
 * 
 * API(Application Programming Interface)
 * - 컴퓨터와 컴퓨터 사이의 상호작용을 위한 연결 방식
 * 
 * @RequestController : Controller가 REST 방식을 처리하기 위한 것임을 암시
 * - 메서드의 리턴 타입으로 사용자가 정의한 클래스 타입도 사용할 수 있고, 
 *   이 외에도 여러 타입으로 보내는데 이를 JSON이나 XML로 자동 처리 
 * 
 * JSON(JavaScript Object Notation)
 * - 데이터를 {}로 묶어서 키와 값으로 구성하는 데이터 포맷
 * */



@RestController
@RequestMapping("/simple")
public class SimpleController {

	// http://localhost:8080/api/simple/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful API!";
	}
	
	@GetMapping("/greet")
	public Person sayGreet() {  // json 형태로 나오게 하려면 maven 에서 Jackson Databind 다운로드 받아야 함 
		Person p = new Person("김예진","다 거짓말");
		return p;
	}
	
	@GetMapping("/allGreet")
	public List<Person> allGreet(){
		List<Person> list = new ArrayList();
		for(int i=0; i<5; i++) {
			Person p = new Person();
			p.setName("금요일" + i);
			p.setMessage("아직 아님..." + i);
			list.add(p);
		}
		return list;
	}
	
	@GetMapping("/sendGreet")
	public Map<Integer,Person> sendGreet(){
		Map<Integer, Person> map = new HashMap();
		map.put(1, new Person("김예진","으랏차차"));  
		return map;
		
		/* 키 안에 키값
		  "1": {
        "name": "김예진",
        "message": "으랏차차"
        */
    }
	}


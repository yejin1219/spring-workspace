package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneService;
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController {

	@Autowired
	private PhoneService service;
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		
		// try~catch 로 처리해도 된다.
		try {
			 //phone전체 리스트  
		     List<Phone> list = service.select();
		     return new ResponseEntity(list, HttpStatus.OK);
		 } catch(RuntimeException e) {
			 return new ResponseEntity( HttpStatus.NO_CONTENT);
		 }
		
		
		/* 조건문으로 처리 해도 되고 
		if(list.isEmpty()) {
			
			return new ResponseEntity(list, HttpStatus.OK); // 상태코드를 같이 보내줄 수 있다. ok일때:200
		}
		  return new ResponseEntity( HttpStatus.NO_CONTENT);
		  
		*/  
		  
		 
		
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity selct(@PathVariable String num) {
		Phone phone = service.select(num);
		
		if(phone != null) {
			return new ResponseEntity(phone, HttpStatus.OK);
		}
		return new ResponseEntity( HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		
		try {
			int result = service.insert(phone);
		    return new ResponseEntity(result, HttpStatus.OK);
		}catch(RuntimeException e) {
			 return new ResponseEntity( HttpStatus.NO_CONTENT);
		 }
		
		
		/*
		if(service.insert(phone)>0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		*/
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		try {
			service.update(phone);
		    return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			 return new ResponseEntity( HttpStatus.NO_CONTENT);
		 }
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			service.delete(num);
		    return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			 return new ResponseEntity( HttpStatus.NO_CONTENT);
		 }
	}
}

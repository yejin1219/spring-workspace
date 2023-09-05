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
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController {

	@Autowired
	private PhoneServiceImpl service;
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		
		//phone전체 리스트  
		List<Phone> list = service.select();
		
		if(list.isEmpty()) {
			
			return new ResponseEntity("list", HttpStatus.OK); // 상태코드를 같이 보내줄 수 있다. ok일때:200
		}
		  return new ResponseEntity("list", HttpStatus.OK);
		
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity selct(@PathVariable String num) {
		Phone phone = service.select(num);
		
		if(phone != null) {
			return new ResponseEntity("list", HttpStatus.OK);
		}
		return new ResponseEntity("error", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		if(service.insert(phone)>0) {
			return new ResponseEntity("list", HttpStatus.OK);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		if(service.update(phone)>0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		if(service.delete(num)>0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
	}
}

package com.kh.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

	private String num;
	private String model;
	private int price;
	private String vcode;
	private Company company;
	
}

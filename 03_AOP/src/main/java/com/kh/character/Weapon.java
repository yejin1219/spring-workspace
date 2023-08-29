package com.kh.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자 만들어주는 역할
@AllArgsConstructor //  차 있는 생성자
public abstract class Weapon {

	
	protected String name;
	public abstract String attack() throws Exception;
}

package com.kh.character;

import static org.assertj.core.api.Assertions.assertThat;

//junit5 가 jupiter임
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CharacterTest {

	// character 빈 등록했기 때문에 Autowired로 가져다 쓸 수 있다.
	@Autowired(required=false)
	private Character character;
	
	@Test
	void test() {}
	
	@Test
	void create() {
		// assertThat :검증 메서드를 사용하기 위한 단언문 라이브러리.
		assertThat(character).isNotNull(); //isNotNull()메서드(검증메서드): character 객체가 null 인지 아닌지 확인 (character 객체가 생성되었는지를 확인 )
		assertThat(character.getWeapon()).isNotNull();
		
	}
	
	@Test
	void questTest() throws Exception {
		assertThat(character.quest("일시점검")).contains("일시점검");
	}
	
	@Test
	void attackTest() throws Exception{
		assertThat(character.getWeapon().attack()).isNotNull();
	}
	
}

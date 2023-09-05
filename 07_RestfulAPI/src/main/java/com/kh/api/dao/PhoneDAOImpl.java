package com.kh.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Repository
public class PhoneDAOImpl implements PhoneDAO{

	@Override
	public int insert(Phone phone) {
		
		return 0;
	}

	@Override
	public int update(Phone phone) {
		
		return 0;
	}

	@Override
	public int delete(String num) {
		
		return 0;
	}

	@Override
	public Phone select(String num) {
		
		return null;
	}

	@Override
	public List<Phone> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

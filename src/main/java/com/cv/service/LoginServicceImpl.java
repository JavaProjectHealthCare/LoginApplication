package com.cv.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.bo.LoginBO;
import com.cv.dao.LoginDAO;
import com.cv.dto.LoginDTO;

@Service("loginService")
public class LoginServicceImpl implements LoginServicce {

	@Autowired
	private LoginDAO dao;
	
	@Override
	public String authenticate(LoginDTO dto) {
		System.out.println("LoginServicceImpl.authenticate()");
		
		LoginBO bo=null;
		int count=0;
		//create LOgin BO object
		bo=new LoginBO();
		//copy dto to bo  Object 
		BeanUtils.copyProperties(dto, bo);
		
		//use service 
		count=dao.validate(bo);
		
		if(count==0)
			return "Invalid Credentials !!!!";
		else 
			return "Valid Credentials !!";
	}//method
}//class

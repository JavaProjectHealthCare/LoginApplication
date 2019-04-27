package com.cv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cv.bo.LoginBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
		 
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM LOGINLIST WHERE userName=? AND PWD=?";
	
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int validate(LoginBO bo) {
		
		System.out.println("LoginDAOImpl.validate()");
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUserName(),bo.getPwd());
		return count;
	}//method
}//class

package com.cv.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cv.command.LoginCommand;
import com.cv.dto.LoginDTO;
import com.cv.service.LoginServicce;

@Controller
@SessionAttributes(value="loginCmd",types=LoginCommand.class)
public class LoginController {
	
	@Autowired
	private LoginServicce loginServicce;
	
	@ModelAttribute("loginCmd")
	public LoginCommand createComand() {
		 return new LoginCommand();
	}
	
	@RequestMapping(value="/login_form.htm",method=RequestMethod.GET)
	public String loginForm(LoginCommand cmd, Map< String, Object> map) {
		map.put("loginCmd",cmd);
		return "login_form";
	}
	
	@RequestMapping(value="/login_form.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("loginCmd")LoginCommand cmd,BindingResult errors) {
		LoginDTO dto=null;
		String result=null;
		//convert command object to DTO Object 
		dto=new LoginDTO();
		BeanUtils.copyProperties(cmd, dto);
		
		//use service class 
		result=loginServicce.authenticate(dto);
		map.put("resultMsg", result);
				
		//return Logical view Name
		
		return "login_form";	
	}//method
	
}//class

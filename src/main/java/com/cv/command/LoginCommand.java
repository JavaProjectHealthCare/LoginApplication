package com.cv.command;

import lombok.Data;

@Data
public class LoginCommand {

	private String userName;
	private String pwd;
	
	public LoginCommand() {
		System.out.println("LoginCommand::0-paramConstructor()");
	}
}

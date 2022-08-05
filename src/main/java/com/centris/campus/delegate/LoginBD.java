package com.centris.campus.delegate;

import com.centris.campus.service.LoginService;
import com.centris.campus.serviceImpl.LoginServiceImpl;

public class LoginBD {
	LoginService service=new LoginServiceImpl();

	public String validateLoginUser(String username, String password) {
		return service.validateLoginUser(username,password);
	}
	
	
}

package com.centris.campus.serviceImpl;

import com.centris.campus.dao.LoginDao;
import com.centris.campus.daoImpl.LoginDaoImpl;
import com.centris.campus.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao dao=new LoginDaoImpl();

	public String validateLoginUser(String username, String password) {
		return dao.validateLoginUser(username,password);
	}

}

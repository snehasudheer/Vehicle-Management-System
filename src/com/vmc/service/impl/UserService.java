package com.vmc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmc.dao.implInt.UserDaoInter;
import com.vmc.models.Login;
import com.vmc.models.UserRegistration;
import com.vmc.service.implInt.UserServiceInter;
import com.vmc.Response.*;

@Service("userService")

public class UserService implements UserServiceInter {

	@Autowired
	UserDaoInter userdao;

	@Override
	public ApiResponse userReg(UserRegistration userregistration) {
		ApiResponse respObj= userdao.userDetails(userregistration);		
			return respObj;
}

	@Override
	public ApiResponse userLogin(Login loginobj) {
		ApiResponse respObj=userdao.loginDetails(loginobj);
		return respObj;
	}
	}
	
	



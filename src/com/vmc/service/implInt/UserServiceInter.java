package com.vmc.service.implInt;

import com.vmc.Response.*;
import com.vmc.models.Login;
import com.vmc.models.UserRegistration;

public interface UserServiceInter {

	ApiResponse userReg(UserRegistration userregistration);

	ApiResponse userLogin(Login loginobj);
	
	

}

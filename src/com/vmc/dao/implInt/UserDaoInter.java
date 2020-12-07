package com.vmc.dao.implInt;

import org.springframework.stereotype.Repository;

import com.vmc.Response.*;
import com.vmc.models.Login;
import com.vmc.models.UserRegistration;

@Repository
public interface UserDaoInter {

	ApiResponse userDetails(UserRegistration userregistration);

	ApiResponse loginDetails(Login loginobj);

}

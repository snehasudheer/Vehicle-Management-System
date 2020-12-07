package com.vmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vmc.models.*;
import com.vmc.service.implInt.UserServiceInter;

import com.vmc.Response.*;


@RestController
public class UserManagmentController {

	@Autowired
	UserServiceInter userService;
	
	@PostMapping(value="/user/Registration")
	
		public ResponseEntity<ApiResponse>UserRegistration(@RequestBody UserRegistration  userregistration){
		ApiResponse respObj=null;
		
		respObj=userService.userReg(userregistration);
		
		
		return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
		
	}
	
	
	@PostMapping(value="/user/Login")
	
	public ResponseEntity<ApiResponse>UserLogin(@RequestBody Login  loginobj){
	ApiResponse respObj=null;
	
	respObj=userService.userLogin(loginobj);
	
	
	return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
	
}
	
}


package com.vmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmc.Response.ApiResponse;
import com.vmc.service.implInt.AdminServiceInter;
import com.vmc.models.*;

@RestController
public class AdminController {
	
	
	@Autowired
	AdminServiceInter adminserviceInter;
	
	
	
	@PostMapping(value="/admin/CustomerDetails")
	public ResponseEntity<ApiResponse>Customer(@RequestBody Detailed detailed){
		ApiResponse respObj=null;
		
		 
		respObj=adminserviceInter.cus(detailed);
		
		return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/admin/EmployeeDetails")
	public ResponseEntity<ApiResponse>Employee(@RequestBody  Detailed detailed){
		ApiResponse respObj=null;
	
		respObj=adminserviceInter.emp(detailed);
		return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/admin/VehicleDetails")
	public ResponseEntity<ApiResponse>VehicleDetails(@RequestBody  Detailed detailed){
		ApiResponse respObj=null;
	
	
		respObj=adminserviceInter.veh(detailed);
		
		
		return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/cust/ViewVehicleDetails")
	public ResponseEntity<ApiResponse>VehicleDetailss(@RequestBody  Detailed detailed){
		ApiResponse respObj=null;
	
	
		respObj=adminserviceInter.cveh(detailed);
		return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
		
	}

}

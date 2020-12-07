package com.vmc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmc.Response.ApiResponse;
import com.vmc.dao.impl.Userdao;
import com.vmc.dao.implInt.AdmindaoInter;
import com.vmc.models.Admin;
import com.vmc.models.Customer;
import com.vmc.models.Detailed;
import com.vmc.models.Employee;
import com.vmc.models.VehicleDetails;
import com.vmc.service.implInt.AdminServiceInter;


@Service("adminService")
public class AdminService implements AdminServiceInter {
	
	@Autowired
	AdmindaoInter admindao;

	@Override
	public ApiResponse cus(Detailed detailed) {
		ApiResponse respObj= admindao.custDetails(detailed);		
		return respObj;
		
	}

	@Override
	public ApiResponse emp(Detailed detailed) {
		ApiResponse respObj= admindao.empDetails(detailed);		
		return respObj;
	}

	@Override
	public ApiResponse veh(Detailed detailed) {
		ApiResponse respObj= admindao.vehDetails(detailed);		
		return respObj;
	}

	@Override
	public ApiResponse cveh(Detailed detailed) {
		ApiResponse respObj= admindao.custvehDetails(detailed);		
		return respObj;
	}

	
	
	
	
	




	}
	
		


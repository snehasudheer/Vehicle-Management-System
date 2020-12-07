package com.vmc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmc.Response.ApiResponse;
import com.vmc.dao.implInt.VehicledaoInter;
import com.vmc.models.Purchase;
import com.vmc.models.VehicleDetails;
import com.vmc.service.implInt.VehicleServiceInter;

@Service("vehicleService")
public class VehicleSerivice implements VehicleServiceInter {
	
	@Autowired
	VehicledaoInter vehicledao;


	@Override
	public ApiResponse vehicleman(VehicleDetails vehicleDetails) 
	{
		ApiResponse respObj= vehicledao.VehicleDetails(vehicleDetails);		
		return respObj;
}


	@Override
	public ApiResponse pur(Purchase purchase) {
		ApiResponse respObj= vehicledao.Purchase(purchase);		
		return respObj;
		
	}
		
		
}

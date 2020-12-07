package com.vmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmc.Response.ApiResponse;
import com.vmc.models.Detailed;
import com.vmc.models.Purchase;
import com.vmc.models.VehicleDetails;
import com.vmc.service.implInt.VehicleServiceInter;
@RestController
public class VehicleManagementController {
	@Autowired
		VehicleServiceInter vehicleService;
		
		@PostMapping(value="/vehicle/management")
		
			public ResponseEntity<ApiResponse>VehicleDetails(@RequestBody VehicleDetails  vehicleDetails){
			ApiResponse respObj=null;
			
			respObj=vehicleService.vehicleman(vehicleDetails);
			
			
			return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
			
		}
		
		
		@PostMapping(value="/Customer/PurchaseDetails")
		public ResponseEntity<ApiResponse>Customer(@RequestBody Purchase purchase){
			ApiResponse respObj=null;
            respObj=vehicleService.pur(purchase);
			
			
			return new ResponseEntity<ApiResponse>(respObj,HttpStatus.OK);
						
	}
}
package com.vmc.dao.implInt;

import org.springframework.stereotype.Repository;

import com.vmc.Response.ApiResponse;
import com.vmc.models.Purchase;
import com.vmc.models.VehicleDetails;

@Repository
public interface VehicledaoInter {

	ApiResponse VehicleDetails(VehicleDetails vehicleDetails);

	ApiResponse Purchase(Purchase purchase);

	

}

package com.vmc.service.implInt;

import com.vmc.Response.ApiResponse;
import com.vmc.models.Purchase;
import com.vmc.models.VehicleDetails;

public interface VehicleServiceInter {

	ApiResponse vehicleman(VehicleDetails vehicleDetails);

	ApiResponse pur(Purchase purchase);

}

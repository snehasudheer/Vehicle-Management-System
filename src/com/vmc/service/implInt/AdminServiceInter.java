package com.vmc.service.implInt;

import com.vmc.Response.ApiResponse;
import com.vmc.models.Admin;
import com.vmc.models.Customer;
import com.vmc.models.Detailed;
import com.vmc.models.Employee;
import com.vmc.models.VehicleDetails;

public interface AdminServiceInter {

	

	ApiResponse cus(Detailed detailed);

	ApiResponse emp(Detailed detailed);

	ApiResponse veh(Detailed detailed);

	ApiResponse cveh(Detailed detailed);

	



}

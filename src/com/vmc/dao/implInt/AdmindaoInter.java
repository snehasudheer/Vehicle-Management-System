package com.vmc.dao.implInt;

import com.vmc.Response.ApiResponse;
import com.vmc.models.Admin;
import com.vmc.models.Customer;
import com.vmc.models.Detailed;
import com.vmc.models.Employee;
import com.vmc.models.Purchase;
import com.vmc.models.VehicleDetails;
import com.vmc.models.VehicleDetailss;

public interface AdmindaoInter {



	ApiResponse custDetails(Detailed detailed);

	ApiResponse empDetails(Detailed detailed);

	ApiResponse vehDetails(Detailed detailed);

	ApiResponse custvehDetails(Detailed detailed);

	ApiResponse VehicleDetailss(VehicleDetailss vehicleDetailss);

	
	
	

}

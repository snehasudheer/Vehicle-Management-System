package com.vmc.utils;

import com.vmc.Response.ApiResponse;

public class VehicleManagmentUtils {

		public ApiResponse setResponseObject(String response, Object data, String message){
			
		ApiResponse respObj =new ApiResponse() ;
		
		respObj.setResponse(response);
		respObj.setMessage(message);
		respObj.setData(data);

		return respObj;

	}

}

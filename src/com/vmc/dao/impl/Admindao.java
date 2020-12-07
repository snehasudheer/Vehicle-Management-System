package com.vmc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.vmc.Response.ApiResponse;
import com.vmc.dao.implInt.AdmindaoInter;
import com.vmc.models.*;
import com.vmc.models.Admin;
import com.vmc.models.Customer;
import com.vmc.models.Employee;
import com.vmc.models.VehicleDetails;
import com.vmc.utils.VehicleManagmentUtils;

import groovyjarjarantlr.collections.List;


@Component
public class Admindao implements AdmindaoInter {
	@Autowired
	DataSource dataSource;
	
	
	@Override
	public ApiResponse VehicleDetailss(VehicleDetailss vehicleDetailss) {
		
		ApiResponse respObj=new ApiResponse();
		
		JdbcTemplate template=new JdbcTemplate(dataSource);
		    
		     int vid=vehicleDetailss.getV_id();
		     System.out.println("v_id"+vid);
		    
			 int vcust_id=vehicleDetailss.getVc_id();
			 System.out.println("vcust_id"+vcust_id);
			 String vno=vehicleDetailss.getV_no();
			 System.out.println("vno"+vno);
			 String v_type=vehicleDetailss.getV_type();
			 System.out.println("v_type"+v_type);
			 int vm_no=vehicleDetailss.getV_modelno();
			 System.out.println("vm_no"+vm_no);
			 String vm_name=vehicleDetailss.getV_modelname();
			 System.out.println("vm_name"+vm_name);
			 int v_pr=vehicleDetailss.getV_price();
			 System.out.println("v_pr"+v_pr);
			 
			
			 
			 VehicleDetails vehdet=new VehicleDetails();
			 vehdet.setV_id(vid);
			 vehdet.setVc_id(vcust_id);
			 vehdet.setV_type(v_type);
			 vehdet.setV_no(vno);
			 vehdet.setV_modelno(vm_no);
			 vehdet.setV_modelname(vm_name);
			 vehdet.setV_price(v_pr);
			return respObj;
	}
	
	
	@Override
	public ApiResponse custDetails(Detailed detailed) {
		
		ApiResponse respObj=new ApiResponse();
		JdbcTemplate template=new JdbcTemplate(dataSource);
		int id1=detailed.getId();
		
	    String sql = "SELECT cf_name, cl_name, c_gender, c_address, c_phno FROM `test`.`customer` WHERE c_id = '" + id1 + "'";
	    System.out.println(sql);
	    ArrayList<Map<String, Object>> retList = (ArrayList<Map<String, Object>>) template.queryForList(sql);
	    ArrayList<Customer> custList = new ArrayList<Customer>();
		
         for(int i=0;i<retList.size();i++)
         {
        	 Customer customer=new Customer();
        	if(retList.get(i).get("cf_name")!=null) {
    		 customer.setCf_name(retList.get(i).get("cf_name").toString());
        	}
    		 else {
    			 customer.setCf_name(null);
    		 }
        	
           if(retList.get(i).get("cl_name")!=null) {
       		 customer.setCl_name(retList.get(i).get("cl_name").toString());
           	}
       		 else {
       			 customer.setCl_name(null);
       		 }
           
           if(retList.get(i).get("c_gender")!=null) {
         		 customer.setC_gender(retList.get(i).get("c_gender").toString());
             	}
         		 else {
         			 customer.setC_gender(null);
         		 }
           
           if(retList.get(i).get("c_address")!=null) {
         		 customer.setC_address(retList.get(i).get("c_address").toString());
             	}
         		 else {
         			 customer.setC_address(null);
         		 }
           
           if(retList.get(i).get("c_phno")!=null) {
        	   customer.setC_phno((int)retList.get(i).get("c_phno"));
        	}
    		 else {
    			 customer.setC_phno(0);
         	
    		 }
           custList.add(customer);
         }
         
           try {
  			 respObj = new VehicleManagmentUtils().setResponseObject("successs", custList, " Customer details viewed sucessfully ");

  			} catch (Exception ex) {
  				ex.printStackTrace();
  				respObj = new VehicleManagmentUtils().setResponseObject("failed",null," Customer details  not viewed ");
  			} 	 
  	    
  		return respObj;
  	
        	
         }
	    
         
         
         
	  

	@Override
	public ApiResponse empDetails(Detailed detailed) {
		
        ApiResponse respObj=new ApiResponse();
		JdbcTemplate template=new JdbcTemplate(dataSource);
		
        int id2=detailed.getId();
		
	    String sql = "SELECT ef_name, el_name, e_gender, e_desg, e_address, e_phno FROM `test`.`employee` WHERE e_id = '" + id2 + "'";
	    System.out.println(sql);
	    
	    
	    ArrayList<Map<String, Object>> retList = (ArrayList<Map<String, Object>>) template.queryForList(sql);
	    ArrayList<Employee> empList = new ArrayList<Employee>();
		
         for(int i=0;i<retList.size();i++)
         {
        	 Employee employee=new Employee();
        	if(retList.get(i).get("ef_name")!=null) {
        		employee.setEf_name(retList.get(i).get("ef_name").toString());
        	}
    		 else {
    			 employee.setEf_name(null);
    		 }
        	
           if(retList.get(i).get("el_name")!=null) {
        	   employee.setEl_name(retList.get(i).get("el_name").toString());
           	}
       		 else {
       			employee.setEl_name(null);
       		 }
           
           if(retList.get(i).get("e_gender")!=null) {
        	   employee.setE_gender(retList.get(i).get("e_gender").toString());
             	}
         		 else {
         			employee.setE_gender(null);
         		 }
           
           if(retList.get(i).get("e_desg")!=null) {
        	   employee.setE_desg(retList.get(i).get("e_desg").toString());
             	}
         		 else {
         			employee.setE_address(null);
         		 }
           
           if(retList.get(i).get("e_address")!=null) {
        	   employee.setE_address(retList.get(i).get("e_address").toString());
             	}
         		 else {
         			employee.setE_address(null);
         		 }
           
           if(retList.get(i).get("e_phno")!=null) {
        	   employee.setE_phno((int)retList.get(i).get("e_phno"));
        	}
    		 else {
    			 employee.setE_phno(0);
         	
    		 }
           empList.add(employee);
         }
	    
	    try {
			 respObj = new VehicleManagmentUtils().setResponseObject("successs", empList, " Employee details viewed sucessfully ");

			} catch (Exception ex) {
				ex.printStackTrace();
				respObj = new VehicleManagmentUtils().setResponseObject("failed",null," Employee details not viewed ");
			} 	 

		return respObj;
	}

	@Override
	public ApiResponse vehDetails(Detailed detailed) {
		
        ApiResponse respObj=new ApiResponse();
		JdbcTemplate template=new JdbcTemplate(dataSource);
		
        int id3=detailed.getId();
		
	    String sql = "SELECT v_type, v_no, vc_id, v_modelno, v_modelname, v_price FROM `test`.`vehicle` WHERE v_id = '" + id3 + "'";
	    System.out.println(sql);
	    
	    
	    ArrayList<Map<String, Object>> retList = (ArrayList<Map<String, Object>>) template.queryForList(sql);
	    ArrayList<VehicleDetails>vehList = new ArrayList<VehicleDetails>();
		
         for(int i=0;i<retList.size();i++)
         {
        	 VehicleDetails vehicleDetails=new VehicleDetails();
        	 
        	 if(retList.get(i).get("v_type")!=null) {
         		vehicleDetails.setV_type(retList.get(i).get("v_type").toString());
         	}
     		 else {
     			vehicleDetails.setV_type(null);
     		 }
        	 
        	 if(retList.get(i).get("v_no")!=null) {
          		vehicleDetails.setV_no(retList.get(i).get("v_no").toString());
          	}
      		 else {
      			vehicleDetails.setV_no(null);
      		 }
        	 
        	 if(retList.get(i).get("vc_id")!=null) {
          		vehicleDetails.setVc_id((int)(retList.get(i).get("vc_id")));
          	}
      		 else {
      			vehicleDetails.setVc_id(0);
      		 }
        	 
        	 if(retList.get(i).get("v_modelno")!=null) {
          		vehicleDetails.setV_modelname(retList.get(i).get("v_modelno").toString());
          	}
      		 else {
      			vehicleDetails.setV_modelname(null);
      		 }
        	 
        	 if(retList.get(i).get("v_modelname")!=null) {
          		vehicleDetails.setV_modelname(retList.get(i).get("v_modelname").toString());
          	}
      		 else {
      			vehicleDetails.setV_modelname(null);
      		 }
        	 
        	 if(retList.get(i).get("v_price")!=null) {
          		vehicleDetails.setV_price((int)(retList.get(i).get("v_price")));
          	}
      		 else {
      			vehicleDetails.setV_price(0);
      		 }
        	 
        	 vehList.add(vehicleDetails);
        	 
         }
	    
	    try {
			 respObj = new VehicleManagmentUtils().setResponseObject("successs", vehList, " Vehicle details viewed sucessfully");

			} catch (Exception ex) {
				ex.printStackTrace();
				respObj = new VehicleManagmentUtils().setResponseObject("failed",null," Vehicle details not viewed");
			} 	 
	  
		return respObj;
	}

	
	@Override
	public ApiResponse custvehDetails(Detailed detailed) {
		
        ApiResponse respObj=new ApiResponse();
		JdbcTemplate template=new JdbcTemplate(dataSource);
		
       // int id4=detailed.getId();
		
	    String sql = "SELECT v_id, v_type, v_no, vc_id, v_modelno, v_modelname, v_price FROM `test`.`vehicle`";
	    System.out.println(sql);
	    
	    
	    ArrayList<Map<String, Object>> retList = (ArrayList<Map<String, Object>>) template.queryForList(sql);
	    ArrayList<VehicleDetailss>cvehList = new ArrayList<VehicleDetailss>();
		
         for(int i=0;i<retList.size();i++)
         {
        	 VehicleDetailss vehicleDetailss=new VehicleDetailss();
        	 
        	 
        	 if(retList.get(i).get("v_id")!=null) {
          		vehicleDetailss.setV_id((int)(retList.get(i).get("v_id")));
          	}
      		 else {
      			vehicleDetailss.setV_id(0);
      		 }
        	 
        	 
        	 if(retList.get(i).get("v_type")!=null) {
         		vehicleDetailss.setV_type(retList.get(i).get("v_type").toString());
         	}
     		 else {
     			vehicleDetailss.setV_type(null);
     		 }
        	 
        	 if(retList.get(i).get("v_no")!=null) {
          		vehicleDetailss.setV_no(retList.get(i).get("v_no").toString());
          	}
      		 else {
      			vehicleDetailss.setV_no(null);
      		 }
        	 
        	 if(retList.get(i).get("vc_id")!=null) {
          		vehicleDetailss.setVc_id((int)(retList.get(i).get("vc_id")));
          	}
      		 else {
      			vehicleDetailss.setVc_id(0);
      		 }
        	 
        	 if(retList.get(i).get("v_modelno")!=null) {
          		vehicleDetailss.setV_modelname(retList.get(i).get("v_modelno").toString());
          	}
      		 else {
      			vehicleDetailss.setV_modelname(null);
      		 }
        	 
        	 if(retList.get(i).get("v_modelname")!=null) {
          		vehicleDetailss.setV_modelname(retList.get(i).get("v_modelname").toString());
          	}
      		 else {
      			vehicleDetailss.setV_modelname(null);
      		 }
        	 
        	 if(retList.get(i).get("v_price")!=null) {
          		vehicleDetailss.setV_price((int)(retList.get(i).get("v_price")));
          	}
      		 else {
      			vehicleDetailss.setV_price(0);
      		 }
        	 
        	 cvehList.add(vehicleDetailss);
        	 
         }
	    
	    try {
			 respObj = new VehicleManagmentUtils().setResponseObject("successs", cvehList, " Vehicle details viewed sucessfully");

			} catch (Exception ex) {
				ex.printStackTrace();
				respObj = new VehicleManagmentUtils().setResponseObject("failed",null," Vehicle details not viewed");
			} 	 
	  
		return respObj;
	}

	

	
}



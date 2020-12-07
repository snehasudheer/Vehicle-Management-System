package com.vmc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.vmc.models.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.vmc.Response.ApiResponse;
import com.vmc.dao.implInt.VehicledaoInter;
//import com.vmc.models.Employee;
import com.vmc.utils.VehicleManagmentUtils;

@Component
public class Vehicledao implements VehicledaoInter {
	
	@Autowired
	DataSource dataSource;

	@Override
	public ApiResponse VehicleDetails(VehicleDetails vehicleDetails) {
		
		ApiResponse respObj=new ApiResponse();
		
		JdbcTemplate template=new JdbcTemplate(dataSource);
		    
		     int vid=vehicleDetails.getV_id();
		     System.out.println("v_id"+vid);
		     String operation=vehicleDetails.getOperation();
		     System.out.println("operation"+operation);
			 int vcust_id=vehicleDetails.getVc_id();
			 System.out.println("vcust_id"+vcust_id);
			 String vno=vehicleDetails.getV_no();
			 System.out.println("vno"+vno);
			 String v_type=vehicleDetails.getV_type();
			 System.out.println("v_type"+v_type);
			 int vm_no=vehicleDetails.getV_modelno();
			 System.out.println("v_type"+v_type);
			 String vm_name=vehicleDetails.getV_modelname();
			 System.out.println("v_type"+v_type);
			 int v_pr=vehicleDetails.getV_price();
			 System.out.println("v_type"+v_type);
			 
			
			 
			 VehicleDetails vehdet=new VehicleDetails();
			 vehdet.setV_id(vid);
			 vehdet.setVc_id(vcust_id);
			 vehdet.setV_type(v_type);
			 vehdet.setV_no(vno);
			 vehdet.setV_modelno(vm_no);
			 vehdet.setV_modelname(vm_name);
			 vehdet.setV_price(v_pr);
			 
			 
			 
			 if(operation.equals("Insert"))
				{
				String sql = "INSERT INTO `test`.`vehicle` "
							+ "(`v_type`,`v_no`,`vc_id`,`v_modelno`,`v_modelname`,`v_price`) VALUES"
							+ "(?,?,?,?,?,?)";
					
					KeyHolder holder = new GeneratedKeyHolder();
					template.update(new PreparedStatementCreator() {
						@Override
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
							//ps.setInt(1,vid);
							ps.setString(1,v_type);
							ps.setString(2,vno);
							ps.setInt(3,vcust_id );
							ps.setInt(4,vm_no );
							ps.setString(5,vm_name );
							ps.setInt(6,v_pr );


							
							return ps;
						}
					}, holder);
					 System.out.println(sql);
					 try {
						 respObj = new VehicleManagmentUtils().setResponseObject("successs", vehdet, "Vehicle Registered sucessfully");
			
						} catch (Exception ex) {
							ex.printStackTrace();
							respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"Vehicle Registered failed");
						} 
					
			}
			
			else if(operation.equals("Update"))
			{
					 String updateQuery = "UPDATE `test`.`vehicle` set  v_type='"+v_type+"',v_no='"+vno+"', vc_id='"+vcust_id+"', "
					 		+ "v_modelno='"+vm_no+"', v_modelname='"+vm_name+"', v_price='"+v_pr+"'  WHERE v_id='"+vid+"'";
					 System.out.println(updateQuery);
					 template.execute(updateQuery);
					 
					 try {
						 respObj = new VehicleManagmentUtils().setResponseObject("successs", vehdet, "Vehicle Updated sucessfully");
			
						} catch (Exception ex) {
							ex.printStackTrace();
							respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"Vehicle Updated failed");
						} 	 
			}
					
			else if(operation.equals("Delete"))
			{
				String deleteQuery="DELETE from `test`.`vehicle` WHERE v_id ='"+vid+"' ";
				 System.out.println(deleteQuery);
				 template.execute(deleteQuery);
				 
				 try {
					 respObj = new VehicleManagmentUtils().setResponseObject("successs", null, "Vehicle Deleted sucessfully");
		
					} catch (Exception ex) {
						ex.printStackTrace();
						respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"Vehicle Deleted failed");
					} 	 
		}
			 
			 
			 
			
			 
	 return respObj;
	 
	}
	@Override
	public ApiResponse Purchase(Purchase purchase) {
		
		ApiResponse respObj=new ApiResponse();
		
		JdbcTemplate template=new JdbcTemplate(dataSource);

		     int pcust_id=purchase.getP_cust_id();
			 System.out.println("pcust_id"+pcust_id);
			 int pveh_id=purchase.getP_veh_id();
			 System.out.println("pveh_id"+pveh_id);
			 int p_amt=purchase.getP_amt();
			 System.out.println("p_amt"+p_amt);
			 String pdate=purchase.getP_date();
			 System.out.println("pdate"+pdate);
			 String otype=purchase.getO_type();
			 System.out.println("otype"+otype);
			 int oid=purchase.getO_id();
			 System.out.println("oid"+oid);
			 int odis=purchase.getO_discount();
			 System.out.println("odis"+odis);
			 int o_val=purchase.getO_valid();
			 System.out.println("o_val"+o_val);
			
			 
			 Purchase purdet=new Purchase();
			 purdet.setP_cust_id(pcust_id);
			 purdet.setP_veh_id(pveh_id);
			 purdet.setP_amt(p_amt);
			 purdet.setP_date(pdate);
			 purdet.setO_type(otype);
			 purdet.setO_id(oid);
			 purdet.setO_discount(odis);
			 purdet.setO_valid(o_val);

			
		//int id1=purchase.getP_cust_id();
		
		     
		String sql = "INSERT INTO `test`.`purchase` "
				+ "(`p_cust_id`,`p_veh_id`,`o_id`,`p_date`,`p_amt`,`o_type`,`o_discount`,`o_valid`) VALUES"
				+ "(?,?,?,?,?,?,?,?)";
		
		System.out.println(sql);
		
		KeyHolder holder = new GeneratedKeyHolder();
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,pcust_id);
				ps.setInt(2,pveh_id);
				ps.setInt(3,oid );
				ps.setString(4,pdate );
				ps.setInt(5,p_amt );
				ps.setString(6,otype );
				ps.setInt(7,odis );
				ps.setInt(8,o_val );
				
				
				return ps;
			}
		}, holder);
		
		
		 try {
			 respObj = new VehicleManagmentUtils().setResponseObject("successs",purdet , "Purchase details viewed sucessfully");

			} catch (Exception ex) {
				ex.printStackTrace();
				
				
				respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"Purchase details viewed failed");
			} 
		
		
		
		
		
	
			/*  String sql1 = "SELECT p_id, p_veh_id, p_amt, p_date, o_type, o_id, o_discount, o_valid FROM `test`.`purchase` WHERE p_cust_id = '" + id1 + "'";
			    System.out.println(sql1);
			    ArrayList<Map<String, Object>> retList = (ArrayList<Map<String, Object>>) template.queryForList(sql1);
			    ArrayList<Purchase> purList = new ArrayList<Purchase>();
			  */  
			    	    
			    
				return respObj;
				
	}
	

	}								 	
		




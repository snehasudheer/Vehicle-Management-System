package com.vmc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.vmc.Response.*;
import com.vmc.dao.implInt.UserDaoInter;
import com.vmc.models.Customer;
import com.vmc.models.Employee;
import com.vmc.models.Login;
import com.vmc.models.UserRegistration;
import com.vmc.utils.VehicleManagmentUtils;

@Component
public class Userdao implements UserDaoInter {
	
	@Autowired
	DataSource dataSource;

	@Override
	public ApiResponse userDetails(UserRegistration userregistration) {
		
	ApiResponse respObj=new ApiResponse();
	
	JdbcTemplate template=new JdbcTemplate(dataSource);
	
	 String usertype=userregistration.getType();
	
	 if(usertype.equals("Employee"))
	 {
		 int eid=userregistration.getEmployee().getE_id();
		 System.out.println("eid"+eid);
		 String efirstName=userregistration.getEmployee().getEf_name();
		 System.out.println("efirstName"+efirstName);
		 String elastName=userregistration.getEmployee().getEl_name();
		 System.out.println("elastName"+elastName);
		 String eGender=userregistration.getEmployee().getE_gender();
		 System.out.println("eGender"+eGender);
		 String edesg=userregistration.getEmployee().getE_desg();
		 System.out.println("edesg"+edesg);
		 String eaddress=userregistration.getEmployee().getE_address();
		 System.out.println("eaddress"+eaddress);
		 int ephone=userregistration.getEmployee().getE_phno();
		 System.out.println("ephno"+ephone);
		 String epswd=userregistration.getEmployee().getE_pswd();
		 System.out.println("epswd"+epswd);
		 
		 
		 
		 Employee employee=new Employee();
		 employee.setE_id(eid);
		 employee.setEf_name(efirstName);
		 employee.setEl_name(elastName);
		 employee.setE_gender(eGender);
		 employee.setE_desg(edesg);
		 employee.setE_address(eaddress);
		 employee.setE_phno(ephone);
		 employee.setE_pswd(epswd);
		 
		 
		 
				String sql = "INSERT INTO `test`.`employee` "
						+ "(`ef_name`,`el_name`,`e_gender`,`e_desg`,`e_address`,`e_phno`,`e_pswd`) VALUES"
						+ "(?,?,?,?,?,?,?)";
				
				KeyHolder holder = new GeneratedKeyHolder();
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, efirstName);
						ps.setString(2,elastName);
						ps.setString(3,eGender );
						ps.setString(4, edesg);
						ps.setString(5,eaddress );
						ps.setInt(6, ephone);
						ps.setString(7,epswd);
						return ps;
					}
				}, holder);
				 try {
					 respObj = new VehicleManagmentUtils().setResponseObject("successs", employee, "User Registerd sucessfully");
		
					} catch (Exception ex) {
						ex.printStackTrace();
						respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"User Registration failed");
					}
			 
		 }
		
	 
	 else if(usertype.equals("Customer")) {
		 
		 int cid=userregistration.getCustomer().getC_id();
		 System.out.println("cid"+cid);
		 String cfirstName=userregistration.getCustomer().getCf_name();
		 System.out.println("cfirstName"+cfirstName);
		 String clastName=userregistration.getCustomer().getCl_name();
		 System.out.println("clastName"+clastName);
		 String cGender=userregistration.getCustomer().getC_gender();
		 System.out.println("cGender"+cGender);
		 String caddress=userregistration.getCustomer().getC_address();
		 System.out.println("caddress"+caddress);
		 int cphone=userregistration.getCustomer().getC_phno();
		 System.out.println("cphno"+cphone);
		 String cpswd=userregistration.getCustomer().getC_pswd();
		 System.out.println("cpswd"+cpswd);
		 
		 Customer customer=new Customer();
		 customer.setC_id(cid);
		 customer.setCf_name(cfirstName);
		 customer.setCl_name(clastName);
		 customer.setC_gender(cGender);
		 customer.setC_address(caddress);
		 customer.setC_phno(cphone);
		 customer.setC_pswd(cpswd);
		 
		 
		 
		 String sql = "INSERT INTO `test`.`customer` "
					+ "(`c_id`,`cf_name`,`cl_name`,`c_gender`,`c_address`,`c_phno`,`c_pswd`) VALUES"
					+ "(?,?,?,?,?,?,?)";
			
			KeyHolder holder = new GeneratedKeyHolder();
			template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, cid);
					ps.setString(2, cfirstName);
					ps.setString(3,clastName);
					ps.setString(4,cGender );
					ps.setString(5,caddress );
					ps.setInt(6, cphone);
					ps.setString(7,cpswd);
					
					return ps;
				}
			}, holder);
			
			 try {
				 respObj = new VehicleManagmentUtils().setResponseObject("successs", customer, "User Registerd sucessfully");
	
				} catch (Exception ex) {
					ex.printStackTrace();
					respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"User Registration failed");
				}
		 
	 }
	

		return respObj;

	}

	@Override
	public ApiResponse loginDetails(Login loginobj) {
		
		ApiResponse respObj=new ApiResponse();
		
		JdbcTemplate template=new JdbcTemplate(dataSource);
		
		 String usertype=loginobj.getType();
		 String username=loginobj.getUsername();
		 String password=loginobj.getPassword();


		 
		 
		 if(usertype.equals("Employee"))
		 {
			String sql= "SELECT ef_name FROM `test`.`employee` WHERE ef_name ='"+username+"' and "
					+ "e_pswd='"+password+"'";
			
		
				String id = template.queryForObject(sql, String.class);

				if (id !=null) {
			
				 respObj = new VehicleManagmentUtils().setResponseObject("successs", id, "User Login sucessfully");
	
				}
	     else
	     { 
					respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"User Login failed");
				}

		 }
		 else if(usertype.equals("Customer")) 
		 {
			 String sql= "SELECT cf_name FROM `test`.`customer` WHERE cf_name ='"+username+"' and "
						+ "c_pswd='"+password+"'";
			System.out.println(sql);
			 
			String id = template.queryForObject(sql, String.class);
			
				//int id = template.queryForObject(sql, Integer.class);

				if (id !=null) {
			
				 respObj = new VehicleManagmentUtils().setResponseObject("successs", id, "User Logined sucessfully");
	
				}else{
					
					respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"User Logined failed");
				}
			 
		 }
		 else if(usertype.equals("Admin"))
		 {	 
			 
			
			
			 if(username.equals("admin") && password.equals("admin"))
			 {
				 respObj = new VehicleManagmentUtils().setResponseObject("successs", null, "User Logined sucessfully");
			 }
			 else 
			 {
				 respObj = new VehicleManagmentUtils().setResponseObject("failed",null,"User Logined failed"); 
			 }
		 }
			
			return respObj;

		
	}	
	


}

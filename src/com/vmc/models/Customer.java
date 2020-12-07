package com.vmc.models;

public class Customer {
     private int c_id;
 	 private String cf_name;
 	 private String cl_name;
 	 private String c_gender;
 	 private String c_address;
 	 private int c_phno;
 	 private String c_pswd;
   

     public String getC_pswd() {
		return c_pswd;
	}
	public void setC_pswd(String c_pswd) {
		this.c_pswd = c_pswd;
	}
	public String getCf_name() {
		return cf_name;
	}
	public void setCf_name(String cf_name) {
		this.cf_name = cf_name;
	}
	
     public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	
     public String getC_gender() {
		return c_gender;
	}
	public void setC_gender(String c_gender) {
		this.c_gender = c_gender;
	}
	
     public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public int getC_phno() {
		return c_phno;
	}
	public void setC_phno(int c_phno) {
		this.c_phno = c_phno;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
}

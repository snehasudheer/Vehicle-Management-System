package com.vmc.models;

public class Admin {
	 private int a_id;
	private String af_name;
 	 private String al_name;
 	 private String a_gender;
 	 private String a_address;
 	private String operation;
 	 
 	 public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAf_name() {
		return af_name;
	}
	public void setAf_name(String af_name) {
		this.af_name = af_name;
	}
	public String getAl_name() {
		return al_name;
	}
	public void setAl_name(String al_name) {
		this.al_name = al_name;
	}
	public String getA_gender() {
		return a_gender;
	}
	public void setA_gender(String a_gender) {
		this.a_gender = a_gender;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public int getA_phno() {
		return a_phno;
	}
	public void setA_phno(int a_phno) {
		this.a_phno = a_phno;
	}
	private int a_phno;
	
	 public int getA_id() {
			return a_id;
		}
	 public void setA_id(int a_id) {
			this.a_id = a_id;
	 }
}

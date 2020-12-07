package com.vmc.models;

public class Purchase {
	//private int p_id;
	private int p_cust_id;
	private int p_veh_id;
	private String p_date;
	private int p_amt;
	private int o_id;
	private String o_type;
	private int o_discount;
	private int o_valid;
	
	
	/*public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}*/
	public int getP_cust_id() {
		return p_cust_id;
	}
	public void setP_cust_id(int p_cust_id) {
		this.p_cust_id = p_cust_id;
	}
	public int getP_veh_id() {
		return p_veh_id;
	}
	public void setP_veh_id(int p_veh_id) {
		this.p_veh_id = p_veh_id;
	}
	
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_amt() {
		return p_amt;
	}
	public void setP_amt(int p_amt) {
		this.p_amt = p_amt;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getO_type() {
		return o_type;
	}
	public void setO_type(String o_type) {
		this.o_type = o_type;
	}
	public int getO_discount() {
		return o_discount;
	}
	public void setO_discount(int o_discount) {
		this.o_discount = o_discount;
	}
	public int getO_valid() {
		return o_valid;
	}
	public void setO_valid(int o_valid) {
		this.o_valid = o_valid;
	}
	

}

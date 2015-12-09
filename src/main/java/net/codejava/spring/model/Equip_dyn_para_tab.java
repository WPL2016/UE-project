package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Equip_dyn_para_tab {
	private Float dyn_para_val;
	private SimpleDateFormat dyn_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String dyn_num;
	private String para_num;
	private String product_num;
	
	public Equip_dyn_para_tab() {
	}

	public Equip_dyn_para_tab(Float dyn_para_val, SimpleDateFormat dyn_time,String dyn_num, String para_num, String product_num) {
		this.dyn_para_val = dyn_para_val;
		this.dyn_time = dyn_time;
		this.dyn_num = dyn_num;
		this.para_num = para_num;
		this.product_num = product_num;
	}

	public Float getDyn_para_val() {
		return dyn_para_val;
	}

	public void setDyn_para_val(Float dyn_para_val) {
		this.dyn_para_val= dyn_para_val;
	}

	public SimpleDateFormat getDyn_time() {
		return dyn_time;
	}

	public void setDyn_time(SimpleDateFormat dyn_time) {
		this.dyn_time = dyn_time;
	}
	
	public String getDyn_num() {
		return dyn_num;
	}

	public void setDyn_num(String dyn_num) {
		this.dyn_num = dyn_num;
	}
	
	public String getPara_num() {
		return para_num;
	}

	public void setPara_num(String para_num) {
		this.para_num = para_num;
	}
	
	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
}

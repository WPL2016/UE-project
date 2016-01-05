package net.codejava.spring.model;


import java.util.Date;

public class Equip_pres_para_tab {
	private Float pres_para_val;
	private Date pres_date = new Date();
	private String pres_num;
	private String product_num;
	private String para_num;
	
	public Equip_pres_para_tab() {
	}

	public Equip_pres_para_tab(Float pres_para_val, Date pres_date, String pres_num, String product_num, String para_num) {
		this.pres_para_val = pres_para_val;
		this.pres_date = pres_date;
		this.pres_num = pres_num;
		this.product_num = product_num;
		this.para_num = para_num;
	}

	public Float getPres_para_val() {
		return pres_para_val;
	}

	public void setPres_para_val(Float pres_para_val) {
		this.pres_para_val = pres_para_val;
	}

	public Date getPres_date() {
		return pres_date;
	}

	public void setPres_date(Date pres_date) {
		this.pres_date = pres_date;
	}

	public String getPres_num() {
		return pres_num;
	}

	public void setPres_num(String pres_num) {
		this.pres_num = pres_num;
	}
	
	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	
	public String getPara_num() {
		return para_num;
	}

	public void setPara_num(String para_num) {
		this.para_num = para_num;
	}
}

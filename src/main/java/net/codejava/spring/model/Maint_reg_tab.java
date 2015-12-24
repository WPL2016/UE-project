package net.codejava.spring.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Maint_reg_tab {
	private String maint_reg_cont;
	private String maint_reg_obj_num;
	private String maint_reg_num;
	private String maint_reg_per_num;
	private Date maint_reg_date = new Date();
	
	public Maint_reg_tab() {
	}

	public Maint_reg_tab(String maint_reg_cont, String maint_reg_obj_num, String maint_reg_num,String maint_reg_per_num,Date maint_reg_date) {
		this.maint_reg_cont = maint_reg_cont;
		this.maint_reg_obj_num = maint_reg_obj_num;	
		this.maint_reg_num = maint_reg_num;
		this.maint_reg_per_num = maint_reg_per_num;
		this.maint_reg_date = maint_reg_date;
	}

	public String getMaint_reg_cont() {
		return maint_reg_cont;
	}

	public void setMaint_reg_cont(String maint_reg_cont) {
		this.maint_reg_cont=maint_reg_cont;
	}

	public String getMaint_reg_obj_num() {
		return maint_reg_obj_num;
	}

	public void setMaint_reg_obj_num(String maint_reg_obj_num) {
		this.maint_reg_obj_num = maint_reg_obj_num;
	}

	public String getMaint_reg_num(){
		return maint_reg_num;
	}

	public void setMaint_reg_num(String maint_reg_num) {
		this.maint_reg_num = maint_reg_num;
	}
	
	public String getMaint_reg_per_num(){
		return maint_reg_per_num;
	}

	public void setMaint_reg_per_num(String maint_reg_per_num) {
		this.maint_reg_per_num = maint_reg_per_num;
	}
	
	public Date getMaint_reg_date(){
		return maint_reg_date;
	}

	public void setMaint_reg_date(Date maint_reg_date) {
		this.maint_reg_date = maint_reg_date;
	}
}
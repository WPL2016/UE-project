package net.codejava.spring.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Maint_plan_tab {
	private String maint_plan_num;
	 @DateTimeFormat( pattern = "yyyy-MM-dd" )

		private Date maint_plan_date = new Date();
		private String maint_plan_cont;
		private String maint_plan_per_num;
		private String maint_plan_obj_num;

		
	public Maint_plan_tab() {
	}

	public Maint_plan_tab(String maint_plan_cont, String maint_plan_obj_num, String maint_plan_num,String maint_plan_per_num,Date maint_plan_date) {
		this.maint_plan_cont = maint_plan_cont;
		this.maint_plan_obj_num = maint_plan_obj_num;	
		this.maint_plan_num = maint_plan_num;
		this.maint_plan_per_num = maint_plan_per_num;
		this.maint_plan_date = maint_plan_date;
	}

	
	public String getMaint_plan_cont() {
		return maint_plan_cont;
	}

	public void setMaint_plan_cont(String maint_plan_cont) {
		this.maint_plan_cont=maint_plan_cont;
	}

	public String getMaint_plan_obj_num() {
		return maint_plan_obj_num;
	}

	public void setMaint_plan_obj_num(String maint_plan_obj_num) {
		this.maint_plan_obj_num = maint_plan_obj_num;
	}

	public String getMaint_plan_num(){
		return maint_plan_num;
	}

	public void setMaint_plan_num(String maint_plan_num) {
		this.maint_plan_num = maint_plan_num;
	}
	
	public String getMaint_plan_per_num(){
		return maint_plan_per_num;
	}

	public void setMaint_plan_per_num(String maint_plan_per_num) {
		this.maint_plan_per_num = maint_plan_per_num;
	}
	
	public Date getMaint_plan_date(){
		return maint_plan_date;
	}

	public void setMaint_plan_date(Date maint_plan_date) {
		this.maint_plan_date = maint_plan_date;
	}
}
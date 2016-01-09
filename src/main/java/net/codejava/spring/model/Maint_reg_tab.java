package net.codejava.spring.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Maint_reg_tab {
	private String maint_reg_cont;
	private String maint_plan_num;
	private String maint_reg_num;
	private String maint_reg_per_num;
	
	 @DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date maint_reg_date;
	
	public Maint_reg_tab() {
	}

	public Maint_reg_tab(String maint_reg_cont, String maint_plan_num, String maint_reg_num,String maint_reg_per_num, @DateTimeFormat( pattern = "yyyy-MM-dd" )Date maint_reg_date) {
		this.maint_reg_cont = maint_reg_cont;
		this.maint_plan_num = maint_plan_num;	
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

	public String getMaint_plan_num() {
		return maint_plan_num;
	}

	public void setMaint_plan_num(String maint_plan_num) {
		this.maint_plan_num = maint_plan_num;
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
	
	public @DateTimeFormat( pattern = "yyyy-MM-dd" ) @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") Date getMaint_reg_date(){
		return maint_reg_date;
	}

	public void setMaint_reg_date(@DateTimeFormat( pattern = "yyyy-MM-dd" ) Date maint_reg_date) {
		this.maint_reg_date = maint_reg_date;
	}
}
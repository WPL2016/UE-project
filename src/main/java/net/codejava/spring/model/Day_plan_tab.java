 package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Day_plan_tab {
	private String produce_plan_recorder_num;
	private String day_plan_num;
	private String produce_plan_num;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date plan_date;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date edit_time;
	private int plan_quan;
	//private int plan_work_time;
	//private String equip_product_relat_num;
	//private String equip_name;
	//private String product_name;
	private String plan_status;
	public Day_plan_tab() {
	}

	public Day_plan_tab(String produce_plan_recorder_num, String produce_plan_num,@DateTimeFormat(pattern="yyyy-MM-dd") Date plan_date,@DateTimeFormat(pattern="yyyy-MM-dd") Date edit_time,int plan_quan,String day_plan_num,String plan_status) {
		this.produce_plan_recorder_num = produce_plan_recorder_num;
		this.produce_plan_num = produce_plan_num;
		this.plan_date = plan_date;	
		this.edit_time = edit_time;
		this.plan_quan = plan_quan;	
		this.day_plan_num = day_plan_num;
		this.plan_status=plan_status;
		
		
	}
	

	
	public String getDay_plan_num() {
		return day_plan_num;
	}

	public void setDay_plan_num(String day_plan_num) {
		this.day_plan_num = day_plan_num;
	}
	public String getProduce_plan_recorder_num() {
		return produce_plan_recorder_num;
	}

	public void setProduce_plan_recorder_num(String produce_plan_recorder_num) {
		this.produce_plan_recorder_num = produce_plan_recorder_num;
	}

	public String getProduce_plan_num() {
		return produce_plan_num;
	}

	public void setProduce_plan_num(String produce_plan_num) {
		this.produce_plan_num = produce_plan_num;
	}

	public @DateTimeFormat(pattern="yyyy-MM-dd") Date getPlan_date() {
		return plan_date;
	}

	public void setPlan_date(@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		this.plan_date = date;
	}
	public @DateTimeFormat(pattern="yyyy-MM-dd") Date getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		this.edit_time = date;
	}
	
	public int getPlan_quan() {
		return plan_quan;
	}

	public void setPlan_quan(int plan_quan) {
		this.plan_quan = plan_quan;
	}
	
	
	public String getPlan_status() {
		return plan_status;
	}

	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}
	
	
	
}
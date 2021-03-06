 package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Work_plan_tab {
	private String equip_product_relat_num;
	private String plan_shift;
	private String work_plan_recorder_num;
	private String work_plan_num;
	private String day_plan_num;
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
	private String product_num;
	private String product_name;
	private String equip_name;
	private String equip_num;
	
	
	public Work_plan_tab() {
	}

	public Work_plan_tab(String product_num,String product_name,String equip_name,String equip_num,String equip_product_relat_num,String plan_shift,String work_plan_recorder_num, String work_plan_num,String day_plan_num,@DateTimeFormat(pattern="yyyy-MM-dd") Date plan_date,@DateTimeFormat(pattern="yyyy-MM-dd") Date edit_time,int plan_quan,String Work_plan_num,String plan_status) {
		this.equip_product_relat_num=equip_product_relat_num;
		this.plan_shift=plan_shift;
		this.work_plan_recorder_num = work_plan_recorder_num;
		this.work_plan_num = work_plan_num;
		this.day_plan_num =day_plan_num;
		this.plan_date = plan_date;	
		this.edit_time = edit_time;
		this.plan_quan = plan_quan;	
		this.plan_status=plan_status;
		this.product_name=product_name;
		this.product_num=product_num;
		this.equip_name=equip_name;
		this.equip_num=equip_num;
		
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num= equip_product_relat_num;
	}
	
	public String getPlan_shift() {
		return plan_shift;
	}

	public void setPlan_shift(String plan_shift) {
		this.plan_shift= plan_shift;
	}
	
	
	public String getWork_plan_num() {
		return work_plan_num;
	}

	public void setWork_plan_num(String work_plan_num) {
		this.work_plan_num = work_plan_num;
	}
	public String getWork_plan_recorder_num() {
		return work_plan_recorder_num;
	}

	public void setWork_plan_recorder_num(String work_plan_recorder_num) {
		this.work_plan_recorder_num = work_plan_recorder_num;
	}

	public String getDay_plan_num() {
		return day_plan_num;
	}

	public void setDay_plan_num(String day_plan_num) {
		this.day_plan_num = day_plan_num;
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
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	
	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
	
	public String getEquip_name() {
		return equip_name;
	}

	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	
}

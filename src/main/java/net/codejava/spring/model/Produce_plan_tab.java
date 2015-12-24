package net.codejava.spring.model;

import java.util.Date;

public class Produce_plan_tab {
	private String produce_plan_recorder_num;
	private String produce_plan_num;
	private Date plan_time;
	private int plan_quan;
	private int plan_work_time;
	private String equip_product_relat_num;
	public Produce_plan_tab() {
	}

	public Produce_plan_tab(String produce_plan_recorder_num, String produce_plan_num, Date plan_time,int plan_quan,int plan_work_time, String equip_product_relat_num) {
		this.produce_plan_recorder_num = produce_plan_recorder_num;
		this.produce_plan_num = produce_plan_num;
		this.plan_time = plan_time;	
		this.plan_quan = plan_quan;	
		this.plan_work_time = plan_work_time;	
		this.equip_product_relat_num = equip_product_relat_num;
		
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

	public Date getPlan_time() {
		return plan_time;
	}

	public void setPlan_time(Date plan_time) {
		this.plan_time = plan_time;
	}
	
	public int getPlan_quan() {
		return plan_quan;
	}

	public void setPlan_quan(int plan_quan) {
		this.plan_quan = plan_quan;
	}
	
	public int getPlan_work_time() {
		return plan_work_time;
	}

	public void setPlan_work_time(int plan_work_time) {
		this.plan_work_time = plan_work_time;
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num = equip_product_relat_num;
	}
}
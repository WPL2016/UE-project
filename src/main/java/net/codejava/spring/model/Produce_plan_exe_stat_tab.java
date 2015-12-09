package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Produce_plan_exe_stat_tab {
	private SimpleDateFormat exe_start_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String produce_plan_exe_stat_recorder_num;
	private String produce_plan_exe_stat_num;
	private String produce_plan_num;
	private String equip_product_relat_num;
	
	public Produce_plan_exe_stat_tab() {
	}

	public Produce_plan_exe_stat_tab(SimpleDateFormat exe_start_time, String produce_plan_exe_stat_recorder_num, String produce_plan_exe_stat_num,String produce_plan_num, String equip_product_relat_num) {
		this.exe_start_time = exe_start_time;
		this.produce_plan_exe_stat_recorder_num = produce_plan_exe_stat_recorder_num;
		this.produce_plan_exe_stat_num = produce_plan_exe_stat_num;	
		this.produce_plan_num=produce_plan_num;
		this.equip_product_relat_num=equip_product_relat_num;
	}

	public SimpleDateFormat getExe_start_time() {
		return exe_start_time;
	}

	public void setExe_start_time(SimpleDateFormat exe_start_time) {
		this.exe_start_time = exe_start_time;
	}

	public String getProduce_plan_exe_stat_recorder_num() {
		return produce_plan_exe_stat_recorder_num;
	}

	public void setProduce_plan_exe_stat_recorder_num(String produce_plan_exe_stat_recorder_num) {
		this.produce_plan_exe_stat_recorder_num = produce_plan_exe_stat_recorder_num;
	}

	public String getProduce_plan_exe_stat_num() {
		return produce_plan_exe_stat_num;
	}

	public void setProduce_plan_exe_stat_num(String produce_plan_exe_stat_num) {
		this.produce_plan_exe_stat_num = produce_plan_exe_stat_num;
	}
	
	public String getProduce_plan_num() {
		return produce_plan_num;
	}

	public void setProduce_plan_num(String produce_plan_num) {
		this.produce_plan_num = produce_plan_num;
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num = equip_product_relat_num;
	}
}
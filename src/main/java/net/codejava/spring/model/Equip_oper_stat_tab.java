package net.codejava.spring.model;

import java.sql.Timestamp;
import java.util.Date;


public class Equip_oper_stat_tab {
	private String stat_reason;
	private String stat_recorder_num;
	private String stat_name;
	private Date stat_time = new Date();
	private String stat_num;
	private String equip_num;

	public Equip_oper_stat_tab() {
	}

	public Equip_oper_stat_tab(String stat_reason, String stat_recorder_num,String stat_name,Date stat_time,String stat_num, String equip_num) {
		this.stat_reason = stat_reason;
		this.stat_recorder_num = stat_recorder_num;
		this.stat_name = stat_name;
		this.stat_time = stat_time;
		this.stat_num = stat_num;
		this.equip_num = equip_num;
	}

	public String getStat_reason() {
		return stat_reason;
	}

	public void setStat_reason(String stat_reason) {
		this.stat_reason= stat_reason;
	}

	public String getStat_recorder_num() {
		return stat_recorder_num;
	}

	public void setStat_recorder_num(String stat_recorder_num) {
		this.stat_recorder_num = stat_recorder_num;
	}
	
	public String getStat_name() {
		return stat_name;
	}

	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}
	

	public Date getStat_time() {
		return stat_time;
	}

	public void setStat_time(Date stat_time) {
		this.stat_time = stat_time;
	}
	
	public String getStat_num() {
		return stat_num;
	}

	public void setStat_num(String stat_num) {
		this.stat_num = stat_num;
	}
	
	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
}

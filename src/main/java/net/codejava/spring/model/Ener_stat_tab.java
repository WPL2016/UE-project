package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Ener_stat_tab {
	private Float ener_val;
	private String ener_stat_num;
	private String ener_type;
	private SimpleDateFormat ener_collect_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String equip_num;
	
	public Ener_stat_tab() {
	}

	public Ener_stat_tab(Float ener_val, String ener_stat_num, String ener_type, SimpleDateFormat ener_collect_time, String equip_num) {
		this.ener_val = ener_val;
		this.ener_stat_num = ener_stat_num;
		this.ener_type = ener_type;
		this.ener_collect_time = ener_collect_time;
		this.equip_num = equip_num;
	}

	public Float getEner_val() {
		return ener_val;
	}

	public void setEner_val(Float ener_val) {
		this.ener_val = ener_val;
	}

	public String getEner_stat_num() {
		return ener_stat_num;
	}

	public void setEner_stat_num(String ener_stat_num) {
		this.ener_stat_num = ener_stat_num;
	}

	public String getEner_type() {
		return ener_type;
	}

	public void setEner_type(String ener_type) {
		this.ener_type = ener_type;
	}

	public SimpleDateFormat getEner_collect_time() {
		return ener_collect_time;
	}

	public void setEner_collect_time(SimpleDateFormat ener_collect_time) {
		this.ener_collect_time = ener_collect_time;
	}
	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
}

package net.codejava.spring.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Atype_use_inf_tab {
	private String atype_use_inf_num;
	 @DateTimeFormat( pattern = "yyyy-MM-dd" )

	private Date chan_date = new Date();
	private int chan_quan;
	private String chan_per_num;
	private String atype_num;
	private String equip_num;

	public Atype_use_inf_tab() {
	}

	public Atype_use_inf_tab(String atype_use_inf_num, Date chan_date, int chan_quan, String chan_per_num, String atype_num, String equip_num) {
		this.atype_use_inf_num = atype_use_inf_num;
		this.chan_date = chan_date;
		this.chan_quan = chan_quan;
		this.chan_per_num = chan_per_num;
		this.atype_num = atype_num;
		this.equip_num = equip_num;
	}

	public String getAtype_use_inf_num() {
		return atype_use_inf_num;
	}

	public void setAtype_use_inf_num(String atype_use_inf_num) {
		this.atype_use_inf_num = atype_use_inf_num;
	}

	public Date getChan_date() {
		return chan_date;
	}

	public void setChan_date(Date chan_date) {
		this.chan_date = chan_date;
	}

	public int getChan_quan() {
		return chan_quan;
	}

	public void setChan_quan(int chan_quan) {
		this.chan_quan = chan_quan;
	}

	public String getChan_per_num() {
		return chan_per_num;
	}

	public void setChan_per_num(String chan_per_num) {
		this.chan_per_num = chan_per_num;
	}
	public String getAtype_num() {
		return atype_num;
	}

	public void setAtype_num(String atype_num) {
		this.atype_num = atype_num;
	}
	
	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
}

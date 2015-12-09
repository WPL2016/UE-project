package net.codejava.spring.model;

public class Equip_para_tab {
	private String para_unit;
	private String para_name;
	private String para_recorder_num;
	private String para_num;
	private Float up_lim_val;
	private Float down_lim_val;
	private String equip_num;

	public Equip_para_tab() {
	}

	public Equip_para_tab(String para_unit, String para_name, String para_recorder_num, String para_num,Float up_lim_val,Float down_lim_val, String equip_num) {
		this.para_unit = para_unit;
		this.para_name = para_name;
		this.para_recorder_num = para_recorder_num;
		this.para_num = para_num;
		this.up_lim_val = up_lim_val;
		this.down_lim_val = down_lim_val;
		this.equip_num = equip_num;
		
	}

	public String getPara_unit() {
		return para_unit;
	}

	public void setPara_unit(String para_unit) {
		this.para_unit = para_unit;
	}

	public String getPara_name() {
		return para_name;
	}

	public void setPara_name(String para_name) {
		this.para_name = para_name;
	}

	public String getPara_recorder_num() {
		return para_recorder_num;
	}

	public void setPara_recorder_num(String para_recorder_num) {
		this.para_recorder_num = para_recorder_num;
	}

	public Float getUp_lim_val() {
		return up_lim_val;
	}

	public void setUp_lim_val(Float up_lim_val) {
		this.up_lim_val = up_lim_val;
	}
	
	public Float getDown_lim_val() {
		return down_lim_val;
	}

	public void setDown_lim_val(Float down_lim_val) {
		this.down_lim_val = down_lim_val;
	}
	
	public String getPara_num() {
		return para_num;
	}

	public void setPara_num(String para_num) {
		this.para_num = para_num;
	}
	
	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
}

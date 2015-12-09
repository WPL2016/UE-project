package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class New_mater_use_stat_tab {
	private Float new_mater_use_quan;
	private SimpleDateFormat new_mater_use_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String new_mater_use_stat_num;
	private String equip_product_relat_num;
	
	public New_mater_use_stat_tab() {
	}

	public New_mater_use_stat_tab(Float new_mater_use_quan, SimpleDateFormat new_mater_use_time, String new_mater_ust_stat_num,String equip_product_relat_num) {
		this.new_mater_use_quan = new_mater_use_quan;
		this.new_mater_use_time = new_mater_use_time;
		this.new_mater_use_stat_num = new_mater_ust_stat_num;	
		this.equip_product_relat_num= equip_product_relat_num;
	}

	public Float getNew_mater_use_quan() {
		return new_mater_use_quan;
	}

	public void setNew_mater_use_quan(Float new_mater_use_quan) {
		this.new_mater_use_quan= new_mater_use_quan;
	}

	public SimpleDateFormat getNew_mater_use_time() {
		return new_mater_use_time;
	}

	public void setNew_mater_use_time(SimpleDateFormat new_mater_use_time) {
		this.new_mater_use_time = new_mater_use_time;
	}

	public String getNew_mater_use_stat_num() {
		return new_mater_use_stat_num;
	}

	public void setNew_mater_use_stat_num(String new_mater_use_stat_num) {
		this.new_mater_use_stat_num = new_mater_use_stat_num;
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num = equip_product_relat_num;
	}
}
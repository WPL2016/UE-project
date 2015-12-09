package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Fou_use_stat_tab {
	private Float fou_use_quan;
	private SimpleDateFormat fou_use_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String fou_use_stat_num;
	private String equip_product_relat_num;
	
	public Fou_use_stat_tab() {
	}

	public Fou_use_stat_tab(Float fou_use_quan, SimpleDateFormat fou_use_time, String fou_use_stat_num, String equip_product_relat_num) {
		this.fou_use_quan = fou_use_quan;
		this.fou_use_time = fou_use_time;
		this.fou_use_stat_num = fou_use_stat_num;	
		this.equip_product_relat_num = equip_product_relat_num ;
	}

	public Float getFou_use_quan() {
		return fou_use_quan;
	}

	public void setFou_use_quan(Float fou_use_quan) {
		this.fou_use_quan= fou_use_quan;
	}

	public SimpleDateFormat getFou_use_time() {
		return fou_use_time;
	}

	public void setFou_use_time(SimpleDateFormat fou_use_time) {
		this.fou_use_time = fou_use_time;
	}

	public String getFou_use_stat_num() {
		return fou_use_stat_num;
	}

	public void setFou_use_stat_num(String fou_use_stat_num) {
		this.fou_use_stat_num = fou_use_stat_num;
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num = equip_product_relat_num;
	}
}
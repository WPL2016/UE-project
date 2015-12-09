package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Produce_prog_tab {
	private String produce_prog_num;
	private SimpleDateFormat bat_produce_start_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String equip_product_relat_num;

	public Produce_prog_tab() {
	}

	public Produce_prog_tab(String produce_prog_num, SimpleDateFormat bat_produce_start_time,String equip_product_relat_num) {
		this.produce_prog_num = produce_prog_num;
		this.bat_produce_start_time= bat_produce_start_time;	
		this.equip_product_relat_num=equip_product_relat_num;
	}

	public String getProduce_prog_num() {
		return produce_prog_num;
	}

	public void setProduce_prog_num(String produce_prog_num) {
		this.produce_prog_num = produce_prog_num;
	}

	public SimpleDateFormat getBat_produce_start_time() {
		return bat_produce_start_time;
	}

	public void setBat_produce_start_time(SimpleDateFormat bat_produce_start_time) {
		this.bat_produce_start_time = bat_produce_start_time;
	}
	
	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num = equip_product_relat_num;
	}

}
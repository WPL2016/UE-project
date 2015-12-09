package net.codejava.spring.model;


public class Equip_product_relat_tab {
	private String equip_product_relat_num;
	private String equip_product_relat_recorder_num;
	private String equip_num;
	private String product_num;
	
	public Equip_product_relat_tab() {
	}

	public Equip_product_relat_tab(String equip_product_relat_num, String equip_product_relat_recorder_num, String equip_num, String product_num) {
		this.equip_product_relat_num = equip_product_relat_num;
		this.equip_product_relat_recorder_num = equip_product_relat_recorder_num;
		this.equip_num = equip_num;
		this.product_num = product_num;
	}

	public String getEquip_product_relat_num() {
		return equip_product_relat_num;
	}

	public void setEquip_product_relat_num(String equip_product_relat_num) {
		this.equip_product_relat_num= equip_product_relat_num;
	}

	public String getEquip_product_relat_recorder_num() {
		return equip_product_relat_recorder_num;
	}

	public void setEquip_product_relat_recorder_num(String equip_product_relat_recorder_num) {
		this.equip_product_relat_recorder_num = equip_product_relat_recorder_num;
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
}

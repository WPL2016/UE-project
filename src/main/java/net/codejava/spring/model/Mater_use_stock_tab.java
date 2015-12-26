package net.codejava.spring.model;


public class Mater_use_stock_tab {
	private String equip_name;

	private String product_name;

	private String new_value;

	private String fou_value;
	
	private String mater_percent;

	public Mater_use_stock_tab() {
	}

	public Mater_use_stock_tab(String product_name, String equip_name, String new_value, String fou_value, String mater_percent) {
		this.product_name = product_name;
		this.equip_name = equip_name;
		this.new_value = new_value;
		this.fou_value = fou_value;
		this.mater_percent = mater_percent;
		
	}



	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}

	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getNew_value() {
		return new_value;
	}
	public void setNew_value(String new_value) {
		this.new_value=  new_value;
	}

	public String getFou_value() {
		return fou_value;
	}
	public void setFou_value(String fou_value) {
		this.fou_value=  fou_value;
	}
	
	public String getMater_percent() {
		return mater_percent;
	}
	public void setMater_percent(String mater_percent) {
		this.mater_percent = mater_percent;
	}
}

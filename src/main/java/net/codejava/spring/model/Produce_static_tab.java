package net.codejava.spring.model;


public class Produce_static_tab {
	private String equip_name;

	private String product_name;

	private String value;

	private String count_qulified_product;
	

	public Produce_static_tab() {
	}

	public Produce_static_tab(String product_name, String equip_name, String value, String count_qulified_product) {
		this.product_name = product_name;
		this.equip_name = equip_name;
		this.value = value;
		this.count_qulified_product = count_qulified_product;
		
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


	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value= value;
	}

	
	public String getCount_qulified_product() {
		return count_qulified_product;
	}
	public void setCount_qulified_product(String count_qulified_product) {
		this.count_qulified_product = count_qulified_product;
	}
}

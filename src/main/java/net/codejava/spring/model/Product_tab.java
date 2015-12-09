package net.codejava.spring.model;

public class Product_tab {
	private String product_num;
	private String product_name;
	private String product_recorder_num;
	private String mater_num;

	public Product_tab() {
	}

	public Product_tab(String product_num, String product_name, String product_recorder_num,String mater_num) {
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_recorder_num = product_recorder_num;
		this.mater_num=mater_num;
	}

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_recorder_num() {
		return product_recorder_num;
	}

	public void setProduct_recorder_num(String product_recorder_num) {
		this.product_recorder_num = product_recorder_num;
	}
	
	public String getMater_num() {
		return mater_num;
	}

	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}

}

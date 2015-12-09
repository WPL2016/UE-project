package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Product_qual_stat_tab {
	private String qual_stat_num;
	private SimpleDateFormat infe_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String infe_rea;
	private String product_num;
	
	public Product_qual_stat_tab() {
	}

	public Product_qual_stat_tab(String qual_stat_num, SimpleDateFormat infe_time, String infe_rea, String product_num) {
		this.qual_stat_num = qual_stat_num;
		this.infe_time = infe_time;
		this.infe_rea = infe_rea;	
		this.product_num=product_num;
	}

	public String getQual_stat_num() {
		return qual_stat_num;
	}

	public void setQual_stat_num(String qual_stat_num) {
		this.qual_stat_num = qual_stat_num;
	}

	public SimpleDateFormat getInfe_time() {
		return infe_time;
	}

	public void setInfe_time(SimpleDateFormat infe_time) {
		this.infe_time = infe_time;
	}

	public String getInfe_rea() {
		return infe_rea;
	}

	public void setInfe_rea(String infe_rea) {
		this.infe_rea = infe_rea;
	}

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
}
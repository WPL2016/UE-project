package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Product_qual_asse_tab {
	private String product_qual_asse_num;
	private String product_qual_asse_cont;
	private String product_qual_asse_res;
	private SimpleDateFormat product_qual_asse_date = new SimpleDateFormat("yyyy-M-dd");
	private String product_qual_asse_per_num;
	private String product_num;

	public Product_qual_asse_tab() {
	}

	public Product_qual_asse_tab(String product_qual_asse_num, String product_qual_asse_cont, String product_qual_asse_res, SimpleDateFormat product_qual_asse_date, String product_qual_ass_per_num, String product_qual_asse_per_num,String product_num) {
		this.product_qual_asse_num = product_qual_asse_num;
		this.product_qual_asse_cont = product_qual_asse_cont;
		this.product_qual_asse_res = product_qual_asse_res;
		this.product_qual_asse_date = product_qual_asse_date;
		this.product_qual_asse_per_num = product_qual_asse_per_num;
	    this.product_num = product_num;
	}

	public String getProduct_qual_asse_num() {
		return product_qual_asse_num;
	}

	public void setProduct_qual_asse_num(String product_qual_asse_num) {
		this.product_qual_asse_num = product_qual_asse_num;
	}

	public String getProduct_qual_asse_cont() {
		return product_qual_asse_cont;
	}

	public void setProduct_qual_asse_cont(String product_qual_asse_cont) {
		this.product_qual_asse_cont = product_qual_asse_cont;
	}

	public String getProduct_qual_asse_res() {
		return product_qual_asse_res;
	}

	public void setProduct_qual_asse_res(String product_qual_asse_res) {
		this.product_qual_asse_res = product_qual_asse_res;
	}

	public SimpleDateFormat getProduct_qual_asse_date() {
		return product_qual_asse_date;
	}

	public void setProduct_qual_asse_date(SimpleDateFormat product_qual_asse_date) {
		this.product_qual_asse_date = product_qual_asse_date;
    }
	
	public String getProduct_qual_asse_per_num() {
		return product_qual_asse_per_num;
	}

	public void setProduct_qual_asse_per_num(String product_qual_ass_per_num) {
		this.product_qual_asse_per_num = product_qual_ass_per_num;
	}
	
	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
}
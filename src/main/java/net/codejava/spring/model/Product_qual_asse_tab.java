package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Product_qual_asse_tab {
	private String product_qual_asse_num;
	private String product_qual_asse_cont;
	private String product_qual_asse_res;
	private String product_qual_asse_per_num;
	private String product_num;

	 @DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date product_qual_asse_date;
	
	public Product_qual_asse_tab() {
	}

	public Product_qual_asse_tab(String product_qual_asse_num, String product_qual_asse_cont, String product_qual_asse_res,@DateTimeFormat(pattern="yyyy-MM-dd")Date product_qual_asse_date, String product_qual_ass_per_num, String product_qual_asse_per_num,String product_num) {
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


	
	public @DateTimeFormat( pattern = "yyyy-MM-dd" ) Date getProduct_qual_asse_date(){
		return product_qual_asse_date;
	}

	public void setProduct_qual_asse_date(@DateTimeFormat( pattern = "yyyy-MM-dd" ) Date product_qual_asse_date) {
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
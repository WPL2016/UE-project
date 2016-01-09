package net.codejava.spring.model;



public class Qual_show_tab {
	private String product_num;
	private String infe_time;
	private Float fpy_val;
	
	
	public Qual_show_tab() {
	}

	public Qual_show_tab(String product_num,String infe_time,Float fpy_val) {

		this.product_num= product_num;	
		this.infe_time = infe_time;
		this.fpy_val = fpy_val;
			}


	
	public String getInfe_time(){
		return infe_time;
	}

	public void setInfe_time(String infe_time) {
		this.infe_time = infe_time;
	}
	

	public Float getFpy_val(){
		return fpy_val;
	}

	public void setFpy_val(Float fpy_val) {
		this.fpy_val = fpy_val;
	}
	
	public String getProduct_num(){
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
}
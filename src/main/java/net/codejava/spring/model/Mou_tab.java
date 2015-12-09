package net.codejava.spring.model;

public class Mou_tab {
	private String mou_sup;
	private String mou_name;
	private String mou_recorder_num;
	private int mou_hole_num;
	private String mou_num;
	private String product_num;
	
	public Mou_tab() {
	}

	public Mou_tab(String mou_sup, String mou_name, String mou_recorder_num,int mou_hole_num,String mou_num,String product_num) {
		this.mou_sup = mou_sup;
		this.mou_name = mou_name;	
		this.mou_recorder_num = mou_recorder_num;
		this.mou_hole_num = mou_hole_num;
		this.mou_num = mou_num;
		this.product_num = product_num;
	}

	public String getMou_sup() {
		return mou_sup;
	}

	public void setMou_sup(String mou_sup) {
		this.mou_sup= mou_sup;
	}

	public String getMou_name() {
		return mou_name;
	}

	public void setMou_name(String mou_name) {
		this.mou_name = mou_name;
	}

	public String getMou_recorder_num(){
		return mou_recorder_num;
	}

	public void setMou_recorder_num(String mou_recorder_num) {
		this.mou_recorder_num = mou_recorder_num;
	}
	
	public int getMou_hole_num(){
		return mou_hole_num;
	}

	public void setMou_hole_num(int mou_hole_num) {
		this.mou_hole_num = mou_hole_num;
	}
	
	public String getMou_num(){
		return mou_num;
	}

	public void setMou_num(String mou_num) {
		this.mou_num = mou_num;
	}
	
	public String getProduct_num(){
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
}
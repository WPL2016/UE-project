package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Mater_stock_stat_tab {
	private String stock_stat_per_num;
	private SimpleDateFormat stock_stat_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String stock_num;
	private Float stock_quan;
	private String mater_num;

	public Mater_stock_stat_tab() {
	}

	public Mater_stock_stat_tab(String stock_stat_per_num, SimpleDateFormat stock_stat_time, String stock_num, Float stock_quan, String mater_num) {
		this.stock_stat_per_num = stock_stat_per_num;
		this.stock_stat_time = stock_stat_time;
		this.stock_num = stock_num;	
		this.stock_quan = stock_quan;
		this.mater_num=mater_num;
	}

	public String getStock_stat_per_num() {
		return stock_stat_per_num;
	}

	public void setStock_stat_per_num(String stock_stat_per_num) {
		this.stock_stat_per_num = stock_stat_per_num;
	}

	public SimpleDateFormat getStock_stat_time() {
		return stock_stat_time;
	}

	public void setStock_stat_time(SimpleDateFormat stock_stat_time) {
		this.stock_stat_time = stock_stat_time;
	}

	public String getStock_num() {
		return stock_num;
	}

	public void setStock_num(String stock_num) {
		this.stock_num = stock_num;
	}
	
	public Float getStock_quan() {
		return stock_quan;
	}

	public void setStock_quan(Float stock_quan) {
		this.stock_quan = stock_quan;
	}
	public String getMater_num() {
		return mater_num;
	}

	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}
}
package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Mater_pur_tab {
	private String mater_num;
	private String mater_name;
	private String stock_stat_per_num;
	private String stock_stat_num;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date stock_stat_time;
	private Float stock_quan;
	
	public Mater_pur_tab() {
	}

	public Mater_pur_tab(String mater_num, String mater_name, String stock_stat_per_num,String stock_stat_num, Date stock_stat_time,Float stock_quan) {
		this.mater_num = mater_num;
		this.mater_name = mater_name;
		this.stock_stat_per_num = stock_stat_per_num;	
		this.stock_stat_num = stock_stat_num;
		this.stock_stat_time = stock_stat_time;
		this.stock_quan = stock_quan;
	}

	public String getMater_num() {
		return mater_num;
	}

	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}

	public String getStock_stat_per_num() {
		return stock_stat_per_num;
	}

	public void setStock_stat_per_num(String stock_stat_per_num) {
		this.stock_stat_per_num = stock_stat_per_num;
	}
	
	public String getMater_name() {
		return mater_name;
	}

	public void setMater_name(String mater_name) {
		this.mater_name = mater_name;
	}
	
	public String getStock_stat_num() {
		return stock_stat_num;
	}

	public void setStock_stat_num(String stock_stat_num) {
		this.stock_stat_num = stock_stat_num;
	}
	
	public Float getStock_quan() {
		return stock_quan;
	}

	public void setStock_quan(Float stock_quan) {
		this.stock_quan = stock_quan;
	}
	
	public Date getStock_stat_time() {
		return stock_stat_time;
	}

	public void setStock_stat_time(Date stock_stat_time) {
		this.stock_stat_time = stock_stat_time;
	}
}
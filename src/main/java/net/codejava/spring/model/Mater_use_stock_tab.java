package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Mater_use_stock_tab {
	private String equip_name;
	private String equip_num;

	private String product_name;
	
	private String mater_name;
	
	private String mater_num;

	private String new_value;

	private String fou_value;
	
	private String mater_percent;
	
	private String mater_unit;
	
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private Date new_mater_use_time;
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private Date fou_mater_use_time;
	public Mater_use_stock_tab() {
	}

	public Mater_use_stock_tab(@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )Date fou_mater_use_time, @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )Date new_mater_use_time,String equip_num,String mater_num,String mater_name,String product_name, String equip_name, String new_value, String fou_value, String mater_percent,String mater_unit) {
		this.equip_num = equip_num;
		this.mater_num = mater_num;
		this.mater_name = mater_name;
		this.product_name = product_name;
		this.new_mater_use_time = new_mater_use_time;
		this.fou_mater_use_time = fou_mater_use_time;
		this.equip_name = equip_name;
		this.new_value = new_value;
		this.fou_value = fou_value;
		this.mater_percent = mater_percent;
		this.mater_unit = mater_unit;
		
	}
	
	public  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")   Date getNew_mater_use_time() {
		return new_mater_use_time;
	}

	public void setNew_mater_use_time(  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) Date new_mater_use_time) {
		this.new_mater_use_time= new_mater_use_time;
	}

	public  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")   Date getFou_mater_use_time() {
		return fou_mater_use_time;
	}

	public void setFou_mater_use_time(  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) Date fou_mater_use_time) {
		this.fou_mater_use_time= fou_mater_use_time;
	}
	
	
	public String getMater_unit() {
		return mater_unit;
	}
	public void setMater_unit(String mater_unit) {
		this.mater_unit = mater_unit;
	}
	
	public String getMater_name() {
		return mater_name;
	}
	public void setMater_name(String mater_name) {
		this.mater_name = mater_name;
	}

	public String getMater_num() {
		return mater_num;
	}
	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}

	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	public String getEquip_num() {
		return equip_num;
	}
	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
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

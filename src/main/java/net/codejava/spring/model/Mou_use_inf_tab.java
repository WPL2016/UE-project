package net.codejava.spring.model;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Mou_use_inf_tab {
	private String mou_use_inf_num;
	private String mou_chan_per_num;
	 @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
	private Date mou_chan_time;
	private String mou_num;
	private String equip_num;

	
	public Mou_use_inf_tab() {
	}

	public Mou_use_inf_tab(String mou_use_inf_num, String mou_chan_per_num,  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )Date mou_chan_time,String mou_num,String equip_num) {
		this.mou_use_inf_num = mou_use_inf_num;
		this.mou_chan_per_num = mou_chan_per_num;	
		this.mou_chan_time = mou_chan_time;
		this.mou_num= mou_num;
		this.equip_num= equip_num;
	}

	public String getMou_use_inf_num() {
		return mou_use_inf_num;
	}

	public void setMou_use_inf_num(String mou_use_inf_num) {
		this.mou_use_inf_num= mou_use_inf_num;
	}

	public  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")   Date getMou_chan_time() {
		return mou_chan_time;
	}

	public void setMou_chan_time(  @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" ) Date mou_chan_time) {
		this.mou_chan_time = mou_chan_time;
	}

	public String getMou_chan_per_num(){
		return mou_chan_per_num;
	}

	public void setMou_chan_per_num(String mou_chan_per_num) {
		this.mou_chan_per_num = mou_chan_per_num;
	}
	
	public String getMou_num(){
		return mou_num;
	}

	public void setMou_num(String mou_num) {
		this.mou_num = mou_num;
	}
	
	public String getEquip_num(){
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
}
package net.codejava.spring.model;

import java.text.SimpleDateFormat;

public class Mou_use_inf_tab {
	private String mou_use_inf_num;
	private String mou_chan_per_num;
	private SimpleDateFormat mou_chan_time = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
	private String mou_num;
	private String equip_num;

	
	public Mou_use_inf_tab() {
	}

	public Mou_use_inf_tab(String mou_use_inf_num, String mou_chan_per_num, SimpleDateFormat mou_chan_time,String mou_num,String equip_num) {
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

	public SimpleDateFormat getMou_chan_time() {
		return mou_chan_time;
	}

	public void setMou_chan_time(SimpleDateFormat mou_chan_time) {
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
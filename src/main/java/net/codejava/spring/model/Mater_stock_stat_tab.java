package net.codejava.spring.model;

public class Mater_stock_stat_tab {
	private String mater_name;
	private String mater_num;
	private Float mater_quan;
	
	public Mater_stock_stat_tab() {
	}

	public Mater_stock_stat_tab(String mater_name, String mater_num,Float mater_quan) {
	
		this.mater_name = mater_name;
	
		this.mater_num = mater_num;
		this.mater_quan = mater_quan;
	}

	
	public Float getMater_quan() {
		return mater_quan;
	}

	public void setMater_quan(Float Mater_quan) {
		this.mater_quan= Mater_quan;
	}
	

	public String getMater_num() {
		return mater_num;
	}

	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}
	
	
	public String getMater_name() {
		return mater_name;
	}

	public void setMater_name(String mater_name) {
		this.mater_name = mater_name;
	}
}
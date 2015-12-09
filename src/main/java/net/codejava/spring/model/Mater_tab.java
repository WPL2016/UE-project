package net.codejava.spring.model;

public class Mater_tab {
	private String mater_sup;
	private String mater_name;
	private String mater_recorder_num;
	private String mater_num;
	private String mater_stan;
	
	public Mater_tab() {
	}

	public Mater_tab(String mater_sup, String mater_name, String mater_recorder_num, String mater_num,String mater_stan) {
		this.mater_sup = mater_sup;
		this.mater_name = mater_name;
		this.mater_recorder_num = mater_recorder_num;	
		this.mater_num = mater_num;
		this.mater_stan = mater_stan;
	}

	public String getMater_sup() {
		return mater_sup;
	}

	public void setMater_sup(String mater_sup) {
		this.mater_sup = mater_sup;
	}

	public String getMater_recorder_num() {
		return mater_recorder_num;
	}

	public void setMater_recorder_num(String mater_recorder_num) {
		this.mater_recorder_num = mater_recorder_num;
	}

	public String getMater_num() {
		return mater_num;
	}

	public void setMater_num(String mater_num) {
		this.mater_num = mater_num;
	}
	
	public String getMater_stan() {
		return mater_stan;
	}

	public void setMater_stan(String mater_stan) {
		this.mater_stan = mater_stan;
	}

	public String getMater_name() {
		return mater_name;
	}

	public void setMater_name(String mater_name) {
		this.mater_name = mater_name;
	}
}
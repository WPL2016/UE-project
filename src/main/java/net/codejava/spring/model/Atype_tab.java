package net.codejava.spring.model;


public class Atype_tab {

	private String atype_num;
	

	private String atype_name;
	

	private String atype_sup;
	

	private String atype_recorder_num;

	public Atype_tab() {
	}

	public Atype_tab(String atype_num, String atype_name, String atype_sup, String atype_recorder_num) {
		this.atype_num = atype_num;
		this.atype_name = atype_name;
		this.atype_sup = atype_sup;
		this.atype_recorder_num = atype_recorder_num;
	}

	public String getAtype_num() {
		return atype_num;
	}

	public void setAtype_num(String atype_num) {
		this.atype_num = atype_num;
	}

	public String getAtype_name() {
		return atype_name;
	}

	public void setAtype_name(String atype_name) {
		this.atype_name = atype_name;
	}

	public String getAtype_sup() {
		return atype_sup;
	}

	public void setAtype_sup(String atype_sup) {
		this.atype_sup = atype_sup;
	}

	public String getAtype_recorder_num() {
		return atype_recorder_num;
	}

	public void setAtype_recorder_num(String atype_recorder_num) {
		this.atype_recorder_num = atype_recorder_num;
	}

}

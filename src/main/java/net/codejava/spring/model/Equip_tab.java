package net.codejava.spring.model;


public class Equip_tab {
	private String equip_sup;

	private String equip_name;

	private String equip_recorder_num;

	private String equip_num;
	
	private String equ_equip_num;

	public Equip_tab() {
	}

	public Equip_tab(String equip_sup, String equip_name, String equip_recorder_num, String equip_num, String equ_equip_num) {
		this.equip_sup = equip_sup;
		this.equip_name = equip_name;
		this.equip_recorder_num = equip_recorder_num;
		this.equip_num = equip_num;
		this.equ_equip_num = equ_equip_num;
	}

	public String getEquip_sup() {
		return equip_sup;
	}

	public void setEquip_sup(String equip_sup) {
		this.equip_sup = equip_sup;
	}

	public String getEquip_name() {
		return equip_name;
	}

	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}

	public String getEquip_recorder_num() {
		return equip_recorder_num;
	}

	public void setEquip_recorder_num(String equip_recorder_num) {
		this.equip_recorder_num = equip_recorder_num;
	}

	public String getEquip_num() {
		return equip_num;
	}

	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}

	public String getEqu_equip_num() {
		return equ_equip_num;
	}

	public void setEqu_equip_num(String equ_equip_num) {
		this.equ_equip_num = equ_equip_num;
	}
}

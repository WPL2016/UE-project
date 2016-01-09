package net.codejava.spring.model;

public class Ener_show_tab {
	private String name;
	private String time;
	private String val;

	
	public Ener_show_tab() {
	}

	public Ener_show_tab(String name, String time, String val) {
		this.name = name;
		this.time= time;	
		this.val = val;
			}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVal(){
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
}
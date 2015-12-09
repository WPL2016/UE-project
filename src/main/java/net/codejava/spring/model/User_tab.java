package net.codejava.spring.model;

public class User_tab {
	private String user_name;
	private String user_password;
	private String user_dep;
	private int user_tel;
	private String user_type;
	private String user_num;
	
	public User_tab() {
	}

	public User_tab(String user_name, String user_password, String user_dep,int user_tel,String user_type,String user_num) {
		this.user_name = user_name;
		this.user_password = user_password;	
		this.user_dep = user_dep;
		this.user_tel = user_tel;
		this.user_type = user_type;
		this.user_num = user_num;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name=user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_dep(){
		return user_dep;
	}

	public void setUser_dep(String user_dep) {
		this.user_dep = user_dep;
	}
	
	public int getUser_tel(){
		return user_tel;
	}

	public void setUser_tel(int user_tel) {
		this.user_tel = user_tel;
	}
	
	public String getUser_type(){
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	public String getUser_num(){
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
}
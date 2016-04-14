package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class User_role_apply {
	
	private String username;
    private String apply_role_type;
    private int apply_flag;
    @DateTimeFormat( pattern = "yyyy-MM-dd" )private Date last_modify_date;
    private String last_modify_user;
	public User_role_apply() {
	}

	public User_role_apply(String username,String apply_role_type,int apply_flag, @DateTimeFormat( pattern = "yyyy-MM-dd" )Date last_modify_date,String last_modify_user) {
		this.username = username;
		this.apply_role_type=apply_role_type;
		this.apply_flag=apply_flag;
		this.last_modify_date=last_modify_date;
		this.last_modify_user=last_modify_user;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApply_role_type() {
		return apply_role_type;
	}

	public void setApply_role_type(String apply_role_type) {
		this.apply_role_type = apply_role_type;
	}

	public int getApply_flag() {
		return apply_flag;
	}

	public void setApply_flag(int apply_flag) {
		this.apply_flag = apply_flag;
	}
	public @DateTimeFormat( pattern = "yyyy-MM-dd" ) Date getLast_modify_date(){
		return last_modify_date;
	}

	public void setLast_modify_date(@DateTimeFormat( pattern = "yyyy-MM-dd" ) Date last_modify_date) {
		this.last_modify_date = last_modify_date;
	}
	public String getLast_modify_user() {
		return last_modify_user;
	}

	public void setLast_modify_user(String last_modify_user) {
		this.last_modify_user = last_modify_user;
	}

	
}

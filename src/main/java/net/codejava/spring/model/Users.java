package net.codejava.spring.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Users {
	private int enabled;
	private String username;
	private String password;
	private String user_dep;
	private String user_tel;
	private String person_name;
	 @DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date birth_day;
	private String user_duty;
	private String email;	
	public Users() {
	}

	public Users(String username, String password,int enabled) {
		this.username = username;
		this.password = password;
		this.enabled =enabled;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_dep(){
		return user_dep;
	}

	public void setUser_dep(String user_dep) {
		this.user_dep = user_dep;
	}
	
	public String getUser_tel(){
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	public String getPerson_name(){
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	
	public @DateTimeFormat( pattern = "yyyy-MM-dd" ) Date getBirth_day(){
		return birth_day;
	}

	public void setBirth_day(  @DateTimeFormat( pattern = "yyyy-MM-dd" ) Date birth_day) {
		this.birth_day = birth_day;
	}
	
	public String getUser_duty(){
		return user_duty;
	}

	public void setUser_duty(String user_duty) {
		this.user_duty = user_duty;
	}
	
	public String getEmail(){
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

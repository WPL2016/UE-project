package net.codejava.spring.model;


public class User_Roles {
	private String username;
	private int role_id;
	


	public User_Roles() {
	}

	public User_Roles(String username, int role_id) {
		this.username = username;
		this.role_id = role_id;

	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username= username;
	}
	


}

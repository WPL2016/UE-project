package net.codejava.spring.model;


public class Users {
	private int enabled;
	private String username;
	private String password;

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

}

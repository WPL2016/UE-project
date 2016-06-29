package net.codejava.spring.model;


public class Roles {
	private int role_id;
	private String role_name;
    private String role_type;

	public Roles() {
	}

	public Roles(String role_name,int role_id,String role_type) {
		this.role_name = role_name;
		this.role_id=role_id;
		this.role_type=role_type;

	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}


}

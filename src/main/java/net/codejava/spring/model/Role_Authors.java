package net.codejava.spring.model;

public class Role_Authors {

	private int author_id;
	private int role_id;
	


	public Role_Authors() {
	}

	public Role_Authors(int author_id, int role_id) {
		this.author_id = author_id;
		this.role_id = role_id;

	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	
	
}

package net.codejava.spring.model;


public class Roles {
	private int id;
	private String name;


	public Roles() {
	}

	public Roles(String name) {
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}

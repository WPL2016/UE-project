package net.codejava.spring.model;

public class Authors {

	private int author_id;
	private String author_name;
    private String author_describe;

	public Authors() {
	}

	public Authors(String author_name,int author_id,String author_describe) {
		this.author_name = author_name;
		this.author_describe=author_describe;
		this.author_id=author_id;

	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_describe() {
		return author_describe;
	}

	public void setAuthor_describe (String author_describe) {
		this.author_describe = author_describe;
	}
	
	
}

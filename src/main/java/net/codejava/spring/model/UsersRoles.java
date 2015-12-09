package net.codejava.spring.model;


public class UsersRoles {
	private int urid;
	private String uid;
	private String rid;


	public UsersRoles() {
	}

	public UsersRoles(String uid, String rid) {
		this.uid = uid;
		this.rid = rid;

	}

	public int getId() {
		return urid;
	}

	public void setId(int urid) {
		this.urid = urid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid= uid;
	}
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.uid= rid;
	}


}

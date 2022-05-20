package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profiles")
public class Profile {

	@Id
	private int id;
	private String name;
	private long mobile;
	private String loc;

	// getters and setters
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	// toString
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", mobile=" + mobile + ", loc=" + loc + "]";
	}

	// parameterized constructor
	public Profile(int id, String name, long mobile, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.loc = loc;
	}

	// default constructor
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {

	
	@Id
	private String userName;
	private String passWord;
	
	//Default constructor
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//parameterized constructor
	public Users(String id, String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}


	//getters and setters
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	//ToString
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
	
	
	
	
	
	
	
}
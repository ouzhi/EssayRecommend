package com.lzjtu.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {	
	private Integer user_Id;  
	private String username;
	private String password;
	private String email;
	private Date createDate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer user_Id, String username, String password,
			String email, Date createDate) {
		super();
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createDate = createDate;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", username=" + username
				+ ", password=" + password + ", email=" + email
				+ ", createDate=" + createDate + "]";
	}
	
	
}

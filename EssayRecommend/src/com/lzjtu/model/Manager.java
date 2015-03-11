package com.lzjtu.model;

import java.io.Serializable;

public class Manager implements Serializable {
	private Integer admin_Id;
	private String username;
	private String password;
	
	public Manager() {
		super();
	}
	public Manager(Integer admin_Id, String username, String password) {
		super();
		this.admin_Id = admin_Id;
		this.username = username;
		this.password = password;
	}
	public Integer getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(Integer admin_Id) {
		this.admin_Id = admin_Id;
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
	@Override
	public String toString() {
		return "Manager [admin_Id=" + admin_Id + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}

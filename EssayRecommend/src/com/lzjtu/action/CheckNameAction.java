package com.lzjtu.action;

import com.lzjtu.model.User;
import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckNameAction extends ActionSupport {
	private String username;
	private String result;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() {
		UserService us = new UserService();
		boolean flag = true;
		if(username.length() < 6) flag = false;
		User u = us.queryOneByUsername(username);
		if(u == null && flag) {
			result = "ok";
		}else {
			result = "error";
		}
		return SUCCESS;
	}
}

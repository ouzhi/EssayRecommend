package com.lzjtu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteAction extends ActionSupport {
	private int userId ;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String execute() {
		UserService us = new UserService();
		if(us.delete(userId)) return SUCCESS;
		else return ERROR;
	}
}

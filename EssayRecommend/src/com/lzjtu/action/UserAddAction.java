package com.lzjtu.action;

import java.util.Date;

import com.lzjtu.model.User;
import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAddAction extends ActionSupport {
	private String username ;   
	private String password ;
	private String email;
	
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

	public String execute() {
		User user = new User();
		user.setCreateDate(new Date());
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		UserService us = new UserService();
		if(us.save(user)) return SUCCESS;
		else return ERROR; //  待添加   保存失败后处理工作（重定向到UserManage.jsp页面   并提示创建新用户失败）
	}
}

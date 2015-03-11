package com.lzjtu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.Manager;
import com.lzjtu.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;

public class BackLoginAction extends ActionSupport {
	private String username;
	private String password;
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
	public String execute() {
		ManagerService ms = new ManagerService() ;
		Manager manager = ms.getAdmin(username, password) ;
		if(manager != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("manager", manager);
			return SUCCESS;
		}
		else return ERROR;
	}
}

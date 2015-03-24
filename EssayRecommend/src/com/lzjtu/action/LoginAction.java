package com.lzjtu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.User;
import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private String prePage;
	
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

	
	public String getPrePage() {
		return prePage;
	}

	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}

	public String execute() {
		UserService us = new UserService();
		User user = us.queryOneByUsernameAndPassword(username, password);
		if(user != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			prePage = (String) session.getAttribute("prePage");
			session.removeAttribute("prePage");
			System.out.println(prePage);
			if(prePage == null) {
				return "index";
			}
			return SUCCESS;
		}
		else return ERROR;
	}
}

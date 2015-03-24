package com.lzjtu.action;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.User;
import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private int pageNo = 1;
	private static int pageSize = 5;
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if(pageNo >= 1)
			this.pageNo = pageNo;
		else this.pageNo = 1;
	}

	public String execute() {
		UserService us = new UserService() ;
		List<User> uList = us.queryList(pageNo, pageSize) ;
		long count = us.total() ;
		long pageCount = (count-1) / pageSize + 1 ;
		if(uList != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("uList", uList);
			String url = request.getRequestURI();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("url", url);
			System.out.println(url);
			return SUCCESS;
		}
		else return ERROR;
	}
}

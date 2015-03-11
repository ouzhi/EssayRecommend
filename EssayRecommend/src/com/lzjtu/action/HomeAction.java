package com.lzjtu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	public String execute() {
		PublicationService publicationService = new PublicationService(); 
		List<Publication> pList = publicationService.queryByPage(1, 10) ;
		if(pList != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("pList", pList);
			return SUCCESS;
		}
		else return ERROR;
	}
}

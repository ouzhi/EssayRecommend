package com.lzjtu.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAction extends ActionSupport{
	private String p_id;
	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String execute() {
		PublicationService publicationService = new PublicationService() ;
		Publication pub = publicationService.get(p_id);
		if(pub != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("publication", pub);
			return SUCCESS;
		}
		return ERROR;
	}
}

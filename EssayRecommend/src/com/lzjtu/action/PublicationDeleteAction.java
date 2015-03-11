package com.lzjtu.action;

import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class PublicationDeleteAction extends ActionSupport {
	private String p_id ;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String execute() {
		PublicationService publicationService = new PublicationService() ;
		if(publicationService.delete(p_id)) return SUCCESS;
		else return ERROR;
	}
}

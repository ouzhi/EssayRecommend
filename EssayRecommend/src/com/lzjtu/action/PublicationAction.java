package com.lzjtu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class PublicationAction extends ActionSupport {
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
		PublicationService publicationService = new PublicationService() ;
		List<Publication> pList = publicationService.queryByPage(pageNo, pageSize) ;
		long count = publicationService.total() ;
		long pageCount = (count-1) / pageSize + 1 ;
		if(pList != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("pList", pList);
			String url = request.getRequestURI();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("url", url);
			return SUCCESS;
		}
		else return ERROR;
	}
}

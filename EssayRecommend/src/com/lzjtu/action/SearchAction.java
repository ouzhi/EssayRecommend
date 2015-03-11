package com.lzjtu.action;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.bson.Document;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	private String searchItem;
	private String searchValue;
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
	public String getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String execute() {
		PublicationService publicationService = new PublicationService() ;
		Document queryDoc = new Document();
		Pattern pattern = Pattern.compile("^.*"+ this.searchValue +".*$",Pattern.CASE_INSENSITIVE);
		queryDoc.append(this.searchItem, pattern);
		List<Publication> pList = publicationService.queryByPage(pageNo, pageSize, queryDoc) ;
		if(pList != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("pList", pList);
			//String url = request.getRequestURI();
			return SUCCESS;
		}
		else return ERROR;
	}
}

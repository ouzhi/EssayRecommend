package com.lzjtu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.bson.Document;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.lzjtu.util.MongoDBConnection;
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
		Document queryDoc = new Document();
		queryDoc.append("pub_Id", p_id);
		Document referenceDoc = MongoDBConnection.queryOne(queryDoc, "recommendItem");
		List<String> recommendId = ((List<String>) referenceDoc.get("recommend_Id"));
		List<String> recommendTitle = ((List<String>) referenceDoc.get("recommend_title"));
		Map<String,String> recommendItems = new HashMap<String,String>();
		for (int i = 0; i < recommendId.size(); i++) {
			recommendItems.put(recommendId.get(i), recommendTitle.get(i));
		}
		if(pub != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("publication", pub);
			request.setAttribute("recommendItems", recommendItems);
			return SUCCESS;
		}
		return ERROR;
	}
}

package com.lzjtu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.DownloadRecord;
import com.lzjtu.service.DownloadRecordService;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadRecordAction extends ActionSupport {
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
		DownloadRecordService drs = new DownloadRecordService() ;
		List<DownloadRecord> downloadRecordList = drs.queryList(pageNo, pageSize) ;
		
		long count = drs.total() ;
		long pageCount = (count-1) / pageSize + 1 ;
		if(downloadRecordList != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("downloadRecordList", downloadRecordList);
			String url = request.getRequestURI();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("url", url);
			return SUCCESS;
		}
		else return ERROR;
	}
}

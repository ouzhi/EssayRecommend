package com.lzjtu.action;

import com.lzjtu.service.DownloadRecordService;
import com.lzjtu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadRecordDeleteAction extends ActionSupport {
	private int download_Id ;
	public int getUserId() {
		return download_Id;
	}

	public void setUserId(int download_Id) {
		this.download_Id = download_Id;
	}
	public String execute() {
		DownloadRecordService drs = new DownloadRecordService() ;
		if(drs.delete(download_Id)) return SUCCESS;
		else return ERROR;
	}
}

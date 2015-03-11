package com.lzjtu.model;

import java.io.Serializable;
import java.util.Date;

public class DownloadRecord implements Serializable {
	private Integer download_Id;
	private Date download_Date;
	private String download_Ip;
	private Integer download_User_Id;
	private String download_Pub_Id;
	public DownloadRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DownloadRecord(Integer download_Id, Date download_Date,
			String download_Ip, Integer download_User_Id, String download_Pub_Id) {
		super();
		this.download_Id = download_Id;
		this.download_Date = download_Date;
		this.download_Ip = download_Ip;
		this.download_User_Id = download_User_Id;
		this.download_Pub_Id = download_Pub_Id;
	}
	public Integer getDownload_Id() {
		return download_Id;
	}
	public void setDownload_Id(Integer download_Id) {
		this.download_Id = download_Id;
	}
	public Date getDownload_Date() {
		return download_Date;
	}
	public void setDownload_Date(Date download_Date) {
		this.download_Date = download_Date;
	}
	public String getDownload_Ip() {
		return download_Ip;
	}
	public void setDownload_Ip(String download_Ip) {
		this.download_Ip = download_Ip;
	}
	public Integer getDownload_User_Id() {
		return download_User_Id;
	}
	public void setDownload_User_Id(Integer download_User_Id) {
		this.download_User_Id = download_User_Id;
	}
	public String getDownload_Pub_Id() {
		return download_Pub_Id;
	}
	public void setDownload_Pub_Id(String download_Pub_Id) {
		this.download_Pub_Id = download_Pub_Id;
	}
	@Override
	public String toString() {
		return "DownloadRecord [download_Id=" + download_Id
				+ ", download_Date=" + download_Date + ", download_Ip="
				+ download_Ip + ", download_User_Id=" + download_User_Id
				+ ", download_Pub_Id=" + download_Pub_Id + "]";
	}
	
	
	
}

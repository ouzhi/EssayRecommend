package com.lzjtu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.DownloadRecord;
import com.lzjtu.model.Publication;
import com.lzjtu.model.User;
import com.lzjtu.service.DownloadRecordService;
import com.opensymphony.xwork2.ActionSupport;

public class PubDownloadAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6610985583713465954L;
	private String filename;

	public void setFilename(String filename) {
		try {
			this.filename = new String(filename.getBytes("ISO-8859-1"),"utf-8");
		}catch(UnsupportedEncodingException e) {
			 e.printStackTrace();
		}
	}
	public String execute() {
		//add download file record
		HttpServletRequest request = ServletActionContext.getRequest();
		String IP = request.getRemoteAddr();
		DownloadRecord dlr = new DownloadRecord();
		dlr.setDownload_Ip(IP);
		dlr.setDownload_Date(new Date());
		dlr.setDownload_Pub_Id(filename.substring(0, 24));
		User user = (User) request.getSession().getAttribute("user");
		dlr.setDownload_User_Id(user.getUser_Id());
		DownloadRecordService drs = new DownloadRecordService();
		drs.save(dlr);
		return SUCCESS;
	}
	
	
	public InputStream getInputStream() throws FileNotFoundException {
		String downFilename = "D:\\毕业设计\\PDF2\\" + filename ;
		File file = new File(downFilename);
		return new FileInputStream(file);
	}
	
	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(filename);
	}
	
	public String getFilename() {
		String agent=ServletActionContext.getRequest().getHeader("user-agent");//根据http头信息获取对应的浏览器类型
        return encodeDownloadFilename(filename,agent);
	}
	
	public String encodeDownloadFilename(String fname , String agent) {
		try {
			fname = URLEncoder.encode(fname, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fname;
	}
}

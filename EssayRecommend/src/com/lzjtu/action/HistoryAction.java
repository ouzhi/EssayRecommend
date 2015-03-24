package com.lzjtu.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.DownloadRecord;
import com.lzjtu.model.Publication;
import com.lzjtu.model.User;
import com.lzjtu.service.DownloadRecordService;
import com.lzjtu.service.PublicationService;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryAction extends ActionSupport{
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int user_id = user.getUser_Id();
		String hql = "from DownloadRecord dlr where dlr.download_User_Id = ?";
		String hqlCount = "select count(*) from DownloadRecord dlr where dlr.download_User_Id = ?";
		String[] param = new String[1];
		param[0] = "" + user_id;
		DownloadRecordService drs = new DownloadRecordService();
		List<DownloadRecord> downloadList = drs.queryList(hql, param, pageNo, pageSize);
		long total = drs.total(hqlCount, param);
		long pageCount = (total - 1) / pageSize + 1;
		List<Publication> pubList = new ArrayList<Publication>();
		PublicationService publicationService = new PublicationService();
		for (int i = 0; i < downloadList.size(); i++) {
			String _id = downloadList.get(i).getDownload_Pub_Id();
			pubList.add(publicationService.get(_id));
		}
		String url = request.getRequestURI();
		request.setAttribute("url", url);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pubList", pubList);
		request.setAttribute("total", total);
		return SUCCESS;
	}
}

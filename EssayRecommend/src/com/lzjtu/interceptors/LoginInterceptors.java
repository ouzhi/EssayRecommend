package com.lzjtu.interceptors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lzjtu.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptors extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2299870362852653730L;
	private String sessionName;
	private String excludeName;
	private List<String> list;

	public List<String> strlsit(String str) {
		String[] s = str.split(",");
		List<String> list = new ArrayList<String>();
		for (String ss : s) {
			list.add(ss.trim());
		}
		return list;
	}

	@Override
	public void init() {
		list = strlsit(excludeName);
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();
		if(!list.contains(actionName)) {
			return invocation.invoke();
		}
		else {
			Map<String,Object> session = invocation.getInvocationContext().getSession();
			HttpServletRequest request = ServletActionContext.getRequest();
			String prePage = request.getHeader("Referer");
			//String queryParam = request.getQueryString();
			//if(queryParam == null) {
			//	queryParam = "";
			//}
			//prePage = prePage + "?" + queryParam;
			System.out.println(prePage);
			User u = (User) session.get(sessionName);
			if(u == null) {
				session.put("prePage",prePage);
				return "login";
			}
			else {
				return invocation.invoke();
			}
		}
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getExcludeName() {
		return excludeName;
	}

	public void setExcludeName(String excludeName) {
		this.excludeName = excludeName;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}

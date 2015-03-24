package com.lzjtu.interceptors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lzjtu.model.Manager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BackLoginInterceptors extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8763077817657287327L;
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
		if(list.contains(actionName)) {
			return invocation.invoke();
		}
		else {
			Map<String,Object> session = invocation.getInvocationContext().getSession();
			Manager m = (Manager) session.get(sessionName);
			if(m == null) {
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

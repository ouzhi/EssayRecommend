package com.lzjtu.service;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.model.Manager;

public class ManagerService {
	public Manager getAdmin(String username,String password) {
		Manager manager = DaoFactory.getManagerDao().find(username, password) ;
		return manager ;
	}
}

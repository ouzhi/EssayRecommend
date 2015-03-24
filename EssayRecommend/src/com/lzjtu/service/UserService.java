package com.lzjtu.service;

import java.util.List;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.model.User;

public class UserService {
	public List<User> queryList() {
		List<User> uList = DaoFactory.getUserDao().queryList();
		return uList ;
	}
	
	public User queryOneByUsernameAndPassword(String username,String password) {
		return DaoFactory.getUserDao().queryOneByUsernameAndPassword(username, password);
	}
	
	public List<User> queryList(int pageNo, int pageSize) {
		List<User> uList = DaoFactory.getUserDao().queryList(pageNo, pageSize);
		return uList ;
	}
	
	public boolean save(User u) {
		return DaoFactory.getUserDao().save(u);
	}
	
	public long total() {
		return DaoFactory.getUserDao().total();
	}
	
	public boolean delete(int userId) {
		return DaoFactory.getUserDao().delete(userId);
	}
	
	public User queryOneByUsername(String username) {
		return DaoFactory.getUserDao().queryOneByUsername(username);
	}
}

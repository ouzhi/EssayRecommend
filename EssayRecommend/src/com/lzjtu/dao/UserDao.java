package com.lzjtu.dao;

import java.util.List;

import com.lzjtu.model.User;

public interface UserDao {
	public abstract boolean save(User u);
	public abstract boolean delete(int userId);
	public abstract void update();
	public abstract List<User> queryList();
	public abstract List<User> queryList(int pageNo, int pageSize);
	public abstract long total();
}

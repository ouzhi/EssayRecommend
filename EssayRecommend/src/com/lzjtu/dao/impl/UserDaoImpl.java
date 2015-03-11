package com.lzjtu.dao.impl;

import java.util.List;

import com.lzjtu.dao.UserDao;
import com.lzjtu.model.User;
import com.lzjtu.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean save(User u) {
		return HibernateUtil.add(u);
	}

	@Override
	public boolean delete(int userId) {
		User u = (User) HibernateUtil.get(User.class, userId);
		return HibernateUtil.delete(u);
	}

	@Override
	public void update() {
		
	}

	@Override
	public List<User> queryList() {
		String hql = "from User u where 1=1";
		List<User> uList = HibernateUtil.query(hql, null);
		return uList;
	}
	
	@Override
	public List<User> queryList(int pageNo, int pageSize) {
		String hql = "from User u where 1=1";
		List<User> uList = HibernateUtil.queryByPage(hql, null, pageNo, pageSize);
		return uList;
	}

	@Override
	public long total() {
		String hql = "select count(*) from User u" ;
		long num = HibernateUtil.getCount(hql, null);
		return num;
	}
}

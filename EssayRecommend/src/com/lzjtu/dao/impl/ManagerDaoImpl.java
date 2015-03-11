package com.lzjtu.dao.impl;

import com.lzjtu.dao.ManagerDao;
import com.lzjtu.model.Manager;
import com.lzjtu.util.HibernateUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager find(String username, String password) {
		String hql = "from Manager m where m.username = ? "
				+ "and m.password = ?" ;
				//+ "'"+ username + "' and u.password = '"
				//+ password + "'" ;
		String[] param = new String[2];
		param[0] = username;
		param[1] = password;
		Manager manager = (Manager) HibernateUtil.queryOne(hql, param);
		return manager;
	}


}

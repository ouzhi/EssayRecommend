package com.lzjtu.dao;

import com.lzjtu.model.Manager;

public interface ManagerDao {
	public Manager find(String username,String password);
}

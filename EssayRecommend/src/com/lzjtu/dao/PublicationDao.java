package com.lzjtu.dao;

import java.util.List;

import com.lzjtu.model.Publication;

public interface PublicationDao {
	public abstract boolean save(Publication publication);
	public abstract boolean delete(String _id);
	public abstract Publication get(String _id);
	public abstract void update();
	public abstract List<Publication> queryByPage(int pageNo, int pageSize);
	public abstract List<Publication> queryByPage(int pageNo, int pageSize, Object obj);
	public abstract long total();
}

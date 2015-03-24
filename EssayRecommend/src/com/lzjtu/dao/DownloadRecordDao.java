package com.lzjtu.dao;

import java.util.List;

import com.lzjtu.model.DownloadRecord;


public interface DownloadRecordDao {
	public abstract boolean save(DownloadRecord u);
	public abstract boolean delete(int download_Id);
	public abstract void update();
	public abstract List<DownloadRecord> queryList();
	public abstract List<DownloadRecord> queryList(String hql,String[] param);
	public abstract List<DownloadRecord> queryList(String hql,String[] param,int pageNo, int pageSize);
	public abstract List<DownloadRecord> queryList(int pageNo, int pageSize);
	public abstract long total();
	public abstract long total(String hql,String[] param);
}

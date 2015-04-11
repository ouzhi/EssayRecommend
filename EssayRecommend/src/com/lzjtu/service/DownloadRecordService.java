package com.lzjtu.service;

import java.util.List;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.model.DownloadRecord;

public class DownloadRecordService {
	public boolean queryOne(int user_Id, String pub_Id) {
		return DaoFactory.getDownloadRecordDao().queryOne(user_Id, pub_Id);
	}
	public List<DownloadRecord> queryList() {
		List<DownloadRecord> DownloadRecordList = DaoFactory.getDownloadRecordDao().queryList();
		return DownloadRecordList ;
	}
	
	public List<DownloadRecord> queryList(String hql, String[] param) {
		List<DownloadRecord> DownloadRecordList = DaoFactory.getDownloadRecordDao().queryList(hql,param);
		return DownloadRecordList ;
	}
	
	public List<DownloadRecord> queryList(String hql, String[] param, int pageNo, int pageSize) {
		List<DownloadRecord> DownloadRecordList = DaoFactory.getDownloadRecordDao().queryList(hql,param,pageNo,pageSize);
		return DownloadRecordList ;
	}
	
	public List<DownloadRecord> queryList(int pageNo, int pageSize) {
		List<DownloadRecord> downloadRecordList = DaoFactory.getDownloadRecordDao().queryList(pageNo, pageSize);
		return downloadRecordList ;
	}
	
	public boolean save(DownloadRecord dr) {
		return DaoFactory.getDownloadRecordDao().save(dr);
	}
	
	public long total() {
		return DaoFactory.getDownloadRecordDao().total();
	}
	
	public long total(String hql,String[] param){
		return DaoFactory.getDownloadRecordDao().total(hql,param);
	}
	
	public boolean delete(int download_Id) {
		return DaoFactory.getDownloadRecordDao().delete(download_Id);
	}
	
	
	
}

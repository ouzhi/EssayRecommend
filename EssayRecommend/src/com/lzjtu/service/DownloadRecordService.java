package com.lzjtu.service;

import java.util.List;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.model.DownloadRecord;

public class DownloadRecordService {
	public List<DownloadRecord> queryList() {
		List<DownloadRecord> DownloadRecordList = DaoFactory.getDownloadRecordDao().queryList();
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
	
	public boolean delete(int download_Id) {
		return DaoFactory.getDownloadRecordDao().delete(download_Id);
	}
}

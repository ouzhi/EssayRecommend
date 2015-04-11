package com.lzjtu.dao.impl;

import java.util.List;

import com.lzjtu.dao.DownloadRecordDao;
import com.lzjtu.model.DownloadRecord;
import com.lzjtu.util.HibernateUtil;

public class DownloadRecordDaoImpl implements DownloadRecordDao {

	@Override
	public boolean save(DownloadRecord dr) {
		return HibernateUtil.add(dr);
	}

	@Override
	public boolean delete(int download_Id) {
		DownloadRecord dr = (DownloadRecord) HibernateUtil.get(DownloadRecord.class, download_Id);
		return HibernateUtil.delete(dr);
	}

	@Override
	public void update() {
		
	}
	

	@Override
	public boolean queryOne(int user_Id, String pub_Id) {
		String hql = "from DownloadRecord dlr where dlr.download_User_Id = ? and dlr.download_Pub_Id = ?";
		String[] param = new String[2];
		param[0] = "" + user_Id;
		param[1] = "" + pub_Id;
		if(HibernateUtil.queryOne(hql, param) != null) {
			return false;
		}
		return true;
	}

	@Override
	public List<DownloadRecord> queryList() {
		String hql = "from DownloadRecord dr where 1=1";
		List<DownloadRecord> downloadRecordList = HibernateUtil.query(hql, null);
		return downloadRecordList;
	}
	
	@Override
	public List<DownloadRecord> queryList(String hql,String[] param) {
		List<DownloadRecord> downloadRecordList = HibernateUtil.query(hql, param);
		return downloadRecordList;
	}
	
	@Override
	public List<DownloadRecord> queryList(String hql,String[] param,int pageNo, int pageSize) {
		List<DownloadRecord> downloadRecordList = HibernateUtil.queryByPage(hql, param, pageNo, pageSize);
		return downloadRecordList;
	}

	@Override
	public List<DownloadRecord> queryList(int pageNo, int pageSize) {
		String hql = "from DownloadRecord dr where 1=1";
		List<DownloadRecord> downloadRecordList = HibernateUtil.queryByPage(hql, null, pageNo, pageSize);
		return downloadRecordList;
	}

	@Override
	public long total() {
		String hql = "select count(*) from DownloadRecord dr" ;
		long num = HibernateUtil.getCount(hql, null);
		return num;
	}
	
	
	@Override
	public long total(String hql, String[] param) {
		return HibernateUtil.getCount(hql, param);
	}
	
	public static void main(String[] args) {
		
	}

	

	

	
}

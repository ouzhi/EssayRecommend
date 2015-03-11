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
	public List<DownloadRecord> queryList() {
		String hql = "from DownloadRecord dr where 1=1";
		List<DownloadRecord> downloadRecordList = HibernateUtil.query(hql, null);
		return downloadRecordList;
	}
	
	@Override
	public List<DownloadRecord> queryList(String hql) {
		List<DownloadRecord> downloadRecordList = HibernateUtil.query(hql, null);
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
	
	public static void main(String[] args) {
		DownloadRecordDao drd = new DownloadRecordDaoImpl();
		String hql = "select top 10 from DownloadRecord drs group by drs.download_Pub_Id order by count(download_Id)";
		List downloadRecordList = drd.queryList(hql);
		for (int i = 0; i < downloadRecordList.size() ; i++) {
			System.out.println(downloadRecordList.get(i));
		}
	}

	
}

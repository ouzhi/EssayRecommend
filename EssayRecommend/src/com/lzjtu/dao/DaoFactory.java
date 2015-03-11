package com.lzjtu.dao;

import com.lzjtu.dao.impl.DownloadRecordDaoImpl;
import com.lzjtu.dao.impl.ManagerDaoImpl;
import com.lzjtu.dao.impl.PublicationDaoImpl;
import com.lzjtu.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static ManagerDao getManagerDao() {
		ManagerDao managerDao = new ManagerDaoImpl() ;
		return managerDao ;
	}
	
	public static UserDao getUserDao() {
		UserDao userDao = new UserDaoImpl() ;
		return userDao ;
	}
	
	public static DownloadRecordDao getDownloadRecordDao() {
		DownloadRecordDao downloadRecordDao = new DownloadRecordDaoImpl() ;
		return downloadRecordDao ;
	}
	
	public static PublicationDao getPublicationDao() {
		PublicationDao publicationDao = new PublicationDaoImpl();
		return publicationDao;
	}
	
}

package com.lzjtu.test;

import com.lzjtu.util.HibernateUtil;

public class HqlTest {
	public static void main(String[] args) {
		String hql = "select count(*) from DownloadRecord dlr where dlr.download_User_Id = ?";
		String[] param = new String[1];
		param[0] = "" + 1;
		long count = HibernateUtil.getCount(hql, param);
		System.out.println(count);
	}
}

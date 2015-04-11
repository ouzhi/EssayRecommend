package com.lzjtu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lzjtu.model.User;
import com.lzjtu.service.UserService;
import com.lzjtu.util.HibernateUtil;

public class HqlTest {
	public static void main(String[] args) {
//		String hql = "select count(*) from DownloadRecord dlr where dlr.download_User_Id = ?";
//		String[] param = new String[1];
//		param[0] = "" + 1;
//		long count = HibernateUtil.getCount(hql, param);
//		System.out.println(count);
		List<String> ss = new ArrayList<String>();
		ss.add("s£¬s");
		ss.add("ss£¬ss");
		System.out.println(ss.toString());
		String re = ss.toString();
		re = re.substring(1, re.length()-1);
		String[] sss = re.split("[£¬ ]");
		for (int i = 0; i < sss.length; i++) {
			System.out.println(sss[i]);
		}
	}
}

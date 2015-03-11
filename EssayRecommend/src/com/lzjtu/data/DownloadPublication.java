package com.lzjtu.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bson.Document;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class DownloadPublication {
	public static final String PATH = "D://毕业设计//PDF/";
	public static final String PATH2 = "D://毕业设计//PDF2/";
	private int num;     //记录数量
	private int start;   //记录起始位置
	
	public DownloadPublication(int num, int start) {
		this.num = num;
		this.start = start;
	}
	
	public void run() {
		try {
			this.doDownload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDownload() throws Exception {
		//获取Mongodb数据库连接
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("computerEngineering") ;
		MongoCollection<Document> coll = db.getCollection("publication");
		MongoCursor<Document> cursor = coll.find().skip(start).limit(num).iterator();
		int i = start; 
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			if (doc.get("view_url") != "") {
				String url = (String) doc.get("view_url");
				int pos = url.lastIndexOf("=");
				String filename = url.substring(pos + 1);
				String filepath = PATH2 + filename + ".pdf";
				System.out.println(filepath);
				System.out.println(url);
				File f = new File(filepath);
				File f_old = new File(PATH + filename);
				if (!f.exists() && !f_old.exists()) {
					download(url, filepath, i);
				} else {
					System.out.println(i + " [Exits] " + filepath);
				}		
			}
			i ++;
		}
		cursor.close();
	}
	
	private void download(String urlString, String filepath, int i) throws MalformedURLException {
		URL url = new URL(urlString);
		try {
			URLConnection con;
			con = url.openConnection();
			InputStream is = con.getInputStream();

			byte[] bs = new byte[1024];
			int len;
			OutputStream os = new FileOutputStream(filepath);
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
			System.out.println((i + " [Finished] " + filepath));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println((i + " [Failed] " + filepath));
		}	
	}
	
	
	public static void main(String[] args) {
		DownloadPublication dp = new DownloadPublication(306,0);
		dp.run();
	}

}

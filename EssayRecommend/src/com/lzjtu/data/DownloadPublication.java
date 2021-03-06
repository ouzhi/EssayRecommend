package com.lzjtu.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.bson.Document;




import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class DownloadPublication extends Thread{
	public static final String PATH = "D://毕业设计//PDF/";
	public static final String PATH2 = "D://毕业设计//PDF2/";
	private int num;     //璁板綍鏁伴噺
	private int start;   //璁板綍璧峰浣嶇疆
	
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
		//鑾峰彇Mongodb鏁版嵁搴撹繛鎺�
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("computerEngineering") ;
		MongoCollection<Document> coll = db.getCollection("publication");
		MongoCursor<Document> cursor = coll.find().skip(start).limit(num).iterator();
		int i = start; 
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			if (doc.get("view_url") != "") {
				String url = (String) doc.get("view_url");
				//int pos = url.lastIndexOf("=");
				//String filename = url.substring(pos + 1);
				String filename = doc.get("_id").toString();
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
	
	private void download(String urlString, String filepath, int i){
		URL url = null;
		try {
			url = new URL(urlString);
			
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
		DownloadPublication dp = new DownloadPublication(11800,7770);
		dp.start();
		
		DownloadPublication dp1 = new DownloadPublication(11800,7770);
		dp1.start();
		
		DownloadPublication dp2 = new DownloadPublication(11800,7770);
		dp2.start();
		
		DownloadPublication dp3 = new DownloadPublication(11800,7770);
		dp3.start();
		
		DownloadPublication dp4 = new DownloadPublication(11800,7770);
		dp4.start();
	}

}

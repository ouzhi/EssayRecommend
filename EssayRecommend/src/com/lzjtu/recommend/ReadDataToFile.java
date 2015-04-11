package com.lzjtu.recommend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ReadDataToFile {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Set<String> words = new HashSet<String>();
		File itemFile = new File("D:\\Java\\publication.txt");
		if(!itemFile.exists()) {
			try {
				itemFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(itemFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("computerEngineering") ;
		MongoCollection<Document> dbCollection = db.getCollection("publication");
		MongoCursor<Document> cursor = dbCollection.find().iterator();
		List<String> keywords_English = null;
		while(cursor.hasNext()) {
			keywords_English = ((List<String>) cursor.next().get("keywords_English")); 
			for (int i = 0; i < keywords_English.size(); i++) {
				
				System.out.println(words.add(keywords_English.get(i)));
				System.out.println(keywords_English.get(i) + "  ");
			}
		}
		System.out.println(words.size());
		writer.write(words.toString());
		writer.flush();
		writer.close();
		mongoClient.close();
	}
}

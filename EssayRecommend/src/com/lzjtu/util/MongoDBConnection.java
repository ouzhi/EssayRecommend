package com.lzjtu.util;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.lzjtu.model.Publication;
import com.lzjtu.service.PublicationService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;


public class MongoDBConnection {
//	private static MongoClient mongoClient = new MongoClient("localhost", 27017);
	private static String dbName = "computerEngineering" ;
	
	
	/**
	 * insert a document to mongodb Database*/
	public static void insert(Document doc, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		dbCollection.insertOne(doc);
		mongoClient.close();
	}
	
	
	/**
	 * delete a document while document equal database a document*/ 
	public static void delete(Document doc, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		dbCollection.findOneAndDelete(doc);
		mongoClient.close();
	}
	
	
	/**
	 * from database get a document while document equal some query */
	public static Document get(Document docQuery, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		Document document = dbCollection.find(docQuery).iterator().next();
		mongoClient.close();
		return document;		
	}
	
	
	
	/**
	 * query some document by page*/
	public static List<Document> queryByPage(int pageNo, int pageSize, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		MongoIterable<Document> mongoIterable = dbCollection.find().skip((pageNo-1) * pageSize).limit(pageSize);
		MongoCursor<Document> mongoCursor = mongoIterable.iterator();
		List<Document> dList = new ArrayList<Document>();
		while(mongoCursor.hasNext()) {
			dList.add(mongoCursor.next());
		}
		mongoClient.close();
		return dList;		
	}
	
	
	/**
	 * query some document by page*/
	public static List<Document> queryByPage(int pageNo, int pageSize, Document queryDoc, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		MongoIterable<Document> mongoIterable = dbCollection.find(queryDoc).skip((pageNo-1) * pageSize).limit(pageSize);
		MongoCursor<Document> mongoCursor = mongoIterable.iterator();
		List<Document> dList = new ArrayList<Document>();
		while(mongoCursor.hasNext()) {
			dList.add(mongoCursor.next());
		}
		mongoClient.close();
		return dList;		
	}
	
	
	/**
	 * query a document*/
	public static Document queryOne(Document docQuery, String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		Document document = dbCollection.find(docQuery).iterator().next();
		mongoClient.close();
		return document;
	}
	
	/**
	 * get total document from database*/
	public static long getCount(String dbCollectionName) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase(dbName) ;
		MongoCollection<Document> dbCollection = db.getCollection(dbCollectionName);
		long num = dbCollection.count();
		mongoClient.close();
		return num;
	}
	
	public static void main(String[] args) {
		PublicationService publicationService = new PublicationService(); 
		List<Publication> pList = publicationService.queryByPage(1, 8) ;
		System.out.println(pList);
	}
}
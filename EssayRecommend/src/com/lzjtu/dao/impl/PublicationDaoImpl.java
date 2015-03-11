package com.lzjtu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.dao.PublicationDao;
import com.lzjtu.model.Publication;
import com.lzjtu.util.DocumentToClass;
import com.lzjtu.util.MongoDBConnection;
import com.mongodb.client.MongoCursor;

public class PublicationDaoImpl implements PublicationDao {

	@Override
	public boolean save(Publication publication) {
		Document doc = DocumentToClass.pubToDocument(publication);
		try {
			MongoDBConnection.insert(doc, "publication");
		} catch(Exception e) {
			System.out.println("Publication数据保存失败!");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String _id) {
		ObjectId objid = new ObjectId(_id);
		Document doc = new Document();
		doc.append("_id", objid);	
		try {
			MongoDBConnection.delete(doc, "publication");
		} catch(Exception e) {
			System.out.println("Publication数据删除失败!");
			return false;
		}
		return true;
	}

	@Override
	public Publication get(String _id) {
		ObjectId objid = new ObjectId(_id);
		Document docQuery = new Document();
		docQuery.append("_id", objid);	
		Publication publication = DocumentToClass.toPublication((MongoDBConnection.get(docQuery, "publication")));
		return publication;
	}

	@Override
	public void update() {
		
	}

	@Override
	public List<Publication> queryByPage(int pageNo, int pageSize) {
		List<Document> documentList = MongoDBConnection.queryByPage(pageNo, pageSize, "publication");
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		for(int i = 0 ; i < documentList.size() ; i ++) {
			publicationList.add(DocumentToClass.toPublication(documentList.get(i)));
		}
		return publicationList;
	}
	
	@Override
	public List<Publication> queryByPage(int pageNo, int pageSize, Object obj) {
		List<Document> documentList = MongoDBConnection.queryByPage(pageNo, pageSize,(Document) obj, "publication");
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		for(int i = 0 ; i < documentList.size() ; i ++) {
			publicationList.add(DocumentToClass.toPublication(documentList.get(i)));
		}
		return publicationList;
	}

	@Override
	public long total() {
		return MongoDBConnection.getCount("publication");
	}

	public static void main(String[] args) {
	}

	
}

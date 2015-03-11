package com.lzjtu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;

import com.lzjtu.dao.DaoFactory;
import com.lzjtu.model.Publication;
import com.mongodb.BasicDBObject;

public class PublicationService {
	public boolean save(Publication publication) {
		return DaoFactory.getPublicationDao().save(publication);
	}

	public boolean delete(String _id) {
		return DaoFactory.getPublicationDao().delete(_id);
	}

	public Publication get(String _id) {
		return DaoFactory.getPublicationDao().get(_id);
	}

	public void update() {
		
	}

	public List<Publication> queryByPage(int pageNo, int pageSize) {
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		publicationList = (ArrayList<Publication>) DaoFactory.getPublicationDao().queryByPage(pageNo, pageSize);
		return publicationList;
	}
	
	public List<Publication> queryByPage(int pageNo, int pageSize, Object obj) {
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		publicationList = (ArrayList<Publication>) DaoFactory.getPublicationDao().queryByPage(pageNo, pageSize,obj);
		return publicationList;
	}

	public long total() {
		return DaoFactory.getPublicationDao().total();
	}
	public static void main(String[] args) {
		PublicationService ps = new PublicationService();
		Document doc = new Document();
		Pattern pattern = Pattern.compile("^.*аж╬Й.*$",Pattern.CASE_INSENSITIVE);
		doc.append("authors", pattern);
		ArrayList<Publication> publicationList = (ArrayList<Publication>) ps.queryByPage(1, 5, doc);
		for (int i = 0; i < publicationList.size(); i++) {
			System.out.println(publicationList.get(i));
		}
	}
}

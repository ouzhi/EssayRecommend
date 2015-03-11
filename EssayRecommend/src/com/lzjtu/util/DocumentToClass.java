package com.lzjtu.util;

import java.util.ArrayList;

import org.bson.Document;

import com.lzjtu.model.Publication;


/**
 * Document集合映射实体类工具包
 * 
 */

public class DocumentToClass {
	/*
	 * MongoDB集合Document映射为实体类Publication*/
	public static Publication toPublication(Document doc) {
		Publication publication = new Publication();
		publication.set_id(doc.getObjectId("_id"));
		publication.setTitle(doc.getString("title"));
		publication.setDoi(doc.getString("doi"));
		publication.setTitle_English(doc.getString("title_English"));
		publication.setView_url(doc.getString("view_url"));
		publication.setAbstracts(doc.getString("abstract"));
		publication.setAbstract_English(doc.getString("abstract_English"));
		publication.setPublication_url(doc.getString("publication_url"));
		publication.setAuthors((ArrayList<String>)doc.get("authors"));
		publication.setKeywords((ArrayList<String>)doc.get("keywords"));
		publication.setKeywords_English((ArrayList<String>)doc.get("keywords_English"));
		publication.setCitaarticles(doc.getString("citaarticles"));
		return publication;
	}
	

	
	/*
	 * Publication实体类转化为Document集合
	 * */
	public static Document pubToDocument(Publication publication) {
		Document doc = new Document();
		doc.append("_id", publication.get_id());
		doc.append("title",publication.getTitle());
		doc.append("title_English",publication.getTitle_English());
		doc.append("doi", publication.getDoi());
		doc.append("view_url",publication.getView_url());
		doc.append("abstract", publication.getAbstracts());
		doc.append("abstract_English", publication.getAbstract_English());
		doc.append("publication_url", publication.getPublication_url());
		doc.append("authors", publication.getAuthors());
		doc.append("keywords", publication.getKeywords());
		doc.append("keywords_English", publication.getKeywords_English());
		doc.append("citaarticles", publication.getCitaarticles());
		return doc;
	}
	
}

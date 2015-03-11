package com.lzjtu.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.bson.types.ObjectId;

public class Publication implements Serializable {
	private ObjectId _id;           //ID
	private String title;
	private String title_English;
	private String doi;
	private String view_url;
	private String abstracts;
	private String abstract_English;
	private String publication_url;
	private ArrayList<String> authors;
	private ArrayList<String> keywords;
	private ArrayList<String> keywords_English;
	private String citaarticles;
	public Publication() {
		super();
	}
	public Publication(ObjectId _id, String title, String title_English,
			String doi, String view_url, String abstracts,
			String abstract_English, String publication_url,
			ArrayList<String> authors, ArrayList<String> keywords,
			ArrayList<String> keywords_English, String citaarticles) {
		super();
		this._id = _id;
		this.title = title;
		this.title_English = title_English;
		this.doi = doi;
		this.view_url = view_url;
		this.abstracts = abstracts;
		this.abstract_English = abstract_English;
		this.publication_url = publication_url;
		this.authors = authors;
		this.keywords = keywords;
		this.keywords_English = keywords_English;
		this.citaarticles = citaarticles;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle_English() {
		return title_English;
	}
	public void setTitle_English(String title_English) {
		this.title_English = title_English;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getView_url() {
		return view_url;
	}
	public void setView_url(String view_url) {
		this.view_url = view_url;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getAbstract_English() {
		return abstract_English;
	}
	public void setAbstract_English(String abstract_English) {
		this.abstract_English = abstract_English;
	}
	public String getPublication_url() {
		return publication_url;
	}
	public void setPublication_url(String publication_url) {
		this.publication_url = publication_url;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	public ArrayList<String> getKeywords_English() {
		return keywords_English;
	}
	public void setKeywords_English(ArrayList<String> keywords_English) {
		this.keywords_English = keywords_English;
	}
	public String getCitaarticles() {
		return citaarticles;
	}
	public void setCitaarticles(String citaarticles) {
		this.citaarticles = citaarticles;
	}
	@Override
	public String toString() {
		return "Publication [_id=" + _id + ", title=" + title
				+ ", title_English=" + title_English + ", doi=" + doi
				+ ", view_url=" + view_url + ", abstracts=" + abstracts
				+ ", abstract_English=" + abstract_English
				+ ", publication_url=" + publication_url + ", authors="
				+ authors + ", keywords=" + keywords + ", keywords_English="
				+ keywords_English + ", citaarticles=" + citaarticles + "]";
	}
	
	
	
}

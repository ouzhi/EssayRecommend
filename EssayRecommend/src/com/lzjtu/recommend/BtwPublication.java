package com.lzjtu.recommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class BtwPublication {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("computerEngineering") ;
		MongoCollection<Document> dbCollection = db.getCollection("publication");
		MongoCollection<Document> dbCollRecom = db.getCollection("recommendItem");
		MongoCursor<Document> cursor = dbCollection.find().iterator();
		
		TreeMap<Double, List<String>> result = null;
		List<String> idList = new ArrayList<String>();
		List<String> titleList = new ArrayList<String>();		
		List<List<String>> keywords_English = new ArrayList<List<String>>();
		Document document = null;
		while(cursor.hasNext()) {
			document = cursor.next();
			idList.add(document.get("_id").toString());
			titleList.add(document.getString("title"));
			keywords_English.add(((List<String>) document.get("keywords_English"))); 
		}
		Document recommendDoc = null;
		List<String> recommendItem = null;
		List<String> recommendId = null;
		List<String> recommendTitle = null;
		for (int i = 0; i < idList.size(); i++) {
			result = new TreeMap<Double, List<String>>();
			for (int j = 0; j < idList.size(); j++) {
				recommendItem = new ArrayList<String>();
				recommendItem.add(idList.get(j));
				recommendItem.add(titleList.get(j));
				result.put((getSimilarDegree(decompose(keywords_English.get(i)),decompose(keywords_English.get(j))))
						,recommendItem);
			}
			result.remove(1.0);
			recommendId = new ArrayList<String>();
			recommendTitle = new ArrayList<String>();
			for(int k = 0; k < 5; k ++) {
				Entry<Double, List<String>> entry = result.lastEntry();
				if(entry == null) break;
				System.out.println(entry.getKey());
				recommendId.add(entry.getValue().get(0));
				recommendTitle.add(entry.getValue().get(1));
				result.remove(entry.getKey(), entry.getValue());
			}
			recommendDoc = new Document();
			recommendDoc.append("pub_Id", idList.get(i));
			recommendDoc.append("recommend_title", recommendTitle);
			recommendDoc.append("recommend_Id", recommendId);
			//System.out.println(recommendDoc);
			dbCollRecom.insertOne(recommendDoc);
		}
				
		mongoClient.close();
	}
	
	
	
	/*
	 * �Թؼ��ʽ��зִʣ��Լ�ȥ���ؼ������е�ǰ�ÿո񣬱������ڿո�������ַ��������*/
	public static List<String> decompose(List<String> keywords) {
		List<String> result = new ArrayList<String>();
		String keyword = null;
		String[] str = null;
		for(int i = 0 ; i < keywords.size() ; i++) {
			keyword = keywords.get(i);
			str = keyword.split(" ");
			for (int j = 0; j < str.length; j++) {
				if(!str[j].equals("")) {
					result.add(str[j]);
				}
			}
		}
		return result;
	}
	
	/*
	 * ���������ַ���(Ӣ���ַ�)�����ƶȣ��򵥵����Ҽ��㣬δ��Ȩ��
	 */
     public static double getSimilarDegree(List<String> str1, List<String> str2)
     {
    	//���������ռ�ģ�ͣ�ʹ��mapʵ�֣�����Ϊ���ֵΪ����Ϊ2�����飬����Ŷ�Ӧ�������ַ����еĳ��ִ���
    	 Map<String, int[]> vectorSpace = new HashMap<String, int[]>();
    	 int[] itemCountArray = null;//Ϊ�˱���Ƶ�������ֲ����������Խ�itemCountArray�����ڴ�
    	
    	 //�Կո�Ϊ�ָ������ֽ��ַ���
    	 for(int i=0; i<str1.size(); ++i)
    	 {
    		 if(vectorSpace.containsKey(str1.get(i)))
    			 ++(vectorSpace.get(str1.get(i))[0]);
    		 else
    		 {
    			 itemCountArray = new int[2];
    	         itemCountArray[0] = 1;
    	         itemCountArray[1] = 0;
    	         vectorSpace.put(str1.get(i), itemCountArray);
    		 }
    	 }
    	 
    	 for(int i=0; i<str2.size(); ++i)
    	 {
    		 if(vectorSpace.containsKey(str2.get(i)))
    			 ++(vectorSpace.get(str2.get(i))[1]);
    		 else
    		 {
    			 itemCountArray = new int[2];
    	         itemCountArray[0] = 0;
    	         itemCountArray[1] = 1;
    	         vectorSpace.put(str2.get(i), itemCountArray);
    		 }
    	 }
    	 
    	 //�������ƶ�
    	 double vector1Modulo = 0.00;//����1��ģ
    	 double vector2Modulo = 0.00;//����2��ģ
    	 double vectorProduct = 0.00; //������
    	 Iterator iter = vectorSpace.entrySet().iterator();
    	 
    	 while(iter.hasNext())
    	 {
    		 Map.Entry entry = (Map.Entry)iter.next();
    		 itemCountArray = (int[])entry.getValue();
    		 
    		 vector1Modulo += itemCountArray[0]*itemCountArray[0];
    		 vector2Modulo += itemCountArray[1]*itemCountArray[1];
    		 
    		 vectorProduct += itemCountArray[0]*itemCountArray[1];
    	 }
    	 
    	 vector1Modulo = Math.sqrt(vector1Modulo);
    	 vector2Modulo = Math.sqrt(vector2Modulo);
    	 
    	 //�������ƶ�
    	 double result = vectorProduct/(vector1Modulo*vector2Modulo);
		 if( Math.abs(result - 1.0) < 1e-6) return 1.0;
		 return result;
     }
}

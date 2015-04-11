# -*- coding: cp936 -*-
from scrapy.spider import Spider
import pymongo
import random
import time
from scrapy.selector import HtmlXPathSelector
from computerEngineering.store import computerEngineering
from computerEngineering.items import PublicationItem
from scrapy.http import Request
from bson.objectid import ObjectId




class PubSpider(Spider):
   name = "sciencepubs"
   allowed_domains = ["www.jsjkx.com"]
   start_urls = []
   
   basic_url = "http://www.jsjkx.com/jsjkx/ch/reader/view_abstract.aspx?file_no="
   #start_urls.append(basic_url)
   for i in range (2013,2016,1):
      for j in range (1,13,1):
         for k in range (1,70,1):
            if k<10:
               kk = "0" + str(k)
            else:
               kk = str(k)
            if j<10:
               jj = "0" + str(j)
            else:
               jj = str(j)
            start_urls.append(basic_url + str(i) + jj + kk + "&flag=1")
               


   def parse(self, response):
      
     	#print response	
   	doi = ''.join(response.xpath('//span[@id="DOI"]/a/text()').extract())
      	title = ''.join(response.xpath('//span[@id="FileTitle"]/text()').extract())
  	title_English = ''.join(response.xpath('//span[@id="EnTitle"]/text()').extract())      
        
        
   	fileno = response.url[-15:-7]
   	download_urls = "http://www.jsjkx.com/jsjkx/ch/reader/create_pdf.aspx?file_no=" + fileno + "&flag=1&journal_id=jsjkx"      
   	abstract = ''.join(response.xpath('//span[@id="Abstract"]/text()').extract())    
   	abstract_English = ''.join(response.xpath('//span[@id="EnAbstract"]/text()').extract())
       
   	keywords = ''.join(response.xpath('//span[@id="KeyWord"]/a/font/u/text()').extract()).split(",")
       
   	keywords_English = ''.join(response.xpath('//span[@id="EnKeyWord"]/a/font/u/text()').extract()).split(",")
       
      	citaarticles = ''.join(response.xpath('//span[@id="ReferenceText"]/text()').extract())
      	

      	
   	authors = citaarticles.split(".")[0].split(",")
       

       
      	pubItem = PublicationItem()
        pubItem['title'] = title
       
   	pubItem['title_English'] = title_English
        pubItem['authors'] = authors
        pubItem['publication_url'] = response.url
        pubItem['view_url'] = download_urls
        pubItem['abstract'] = abstract
       
   	pubItem['abstract_English'] = abstract_English
        pubItem['doi'] = doi
        pubItem['keywords'] = keywords
       
   	pubItem['keywords_English'] = keywords_English
        pubItem['citaarticles'] = citaarticles

        #print pubItem
       
        spec = { "title": pubItem['title'] }
        computerEngineering.publication.update(spec, {'$set': dict(pubItem)}, upsert=True)

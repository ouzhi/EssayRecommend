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
   name = "researchpubs"
   allowed_domains = ["crad.ict.ac.cn"]
   start_urls = []
   
   basic_url = "http://crad.ict.ac.cn/CN/abstract/abstract"
   #start_urls.append(basic_url)
   for i in range (2050,2903,1):
   
  	start_urls.append(basic_url + str(i) + ".shtml")
   

   


   def parse(self, response):
      
     	#print response	
   	doi = ''.join(response.xpath('//meta[@name="DC.Identifier"]/@content').extract())
      	title = ''.join(response.xpath('//meta[@name="DC.Title"]/@content').extract())
  	title_English = ''.join(response.xpath('//meta[@name="citation_title"][2]/@content').extract())      
        authors = response.xpath('//meta[@name="DC.Contributor"]/@content').extract()      
   	download_urls = ''.join(response.xpath('//meta[@name="citation_pdf_url"]/@content').extract())      
   	abstract = ''.join(response.xpath('//span[@class="J_zhaiyao"]/text()').extract())    
   	abstract_English = ''.join(response.xpath('//span[@class="J_zhaiyao_en"]/text()').extract())
       
   	keywords = ''.join(response.xpath('//meta[@name="DC.Keywords"][1]/@content').extract()).split(',')
       
   	keywords_English = ''.join(response.xpath('//meta[@name="DC.Keywords"][2]/@content').extract()).split(',')
       
      	citaarticles = ''.join(response.xpath('//td[@class="J_zhaiyao_en"]/text()').extract())
       

       
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

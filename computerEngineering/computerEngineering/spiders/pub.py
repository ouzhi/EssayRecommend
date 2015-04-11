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




class PublicationSpider(Spider):
   name = "publication"
   allowed_domains = ["http://www.ecice06.com"]
   start_urls = []
   basic_url = "http://www.ecice06.com/CN/article/showByInYearList.do?flag=2&time=6&pager="
   for start in range(1, 12, 1): 
      start_urls.append(basic_url + str(start))
   #print start_urls

   def parse(self, response):
      has = HtmlXPathSelector(response)
      print response,has
      pub_urls = ''.join(response.xpath('//A[@class=12]').extract())
      
      print pub_urls
      for pub_url in pub_urls:    
   	 print pub_url
         yield Request(url=pub_url, callback=self.parse_pubs, dont_filter=True)

   def parse_pubs(self, response):
   
   	doi = ''.join(response.xpath('//meta[@name="DC.Identifier"]/@content').extract())
      	title = ''.join(response.xpath('//meta[@name="DC.Title"]/@content').extract())
       
   	title_English = ''.join(response.xpath('//meta[@name="citation_title" & @xml:lang="en"]/@content').extract())
       
        authors = ''.join(response.xpath('//meta[@name="DC.Contributor"]/@content').extract()).split(',')
       
   	download_urls = ''.join(response.xpath('//meta[@name="citation_pdf_url"]/@content').extract())
       
   	abstract = ''.join(response.xpath('//td[@class="J_zhaiyao"][1]/text()').extract())
       
   	abstract_English = ''.join(response.xpath('//span[@class="J_zhaiyao"][1]/text()').extract())
       
   	keywords = ''.join(response.xpath('//meta[@name="DC.Keywords" & @xml:lang="cn"]/@content').extract()).split(',')
       
   	keywords_English = ''.join(response.xpath('//meta[@name="DC.Keywords" & @xml:lang="en"]/@content').extract()).split(',')
       
      	citaarticles = ''.join(response.xpath('//td[@class="txt_12"][3]/text()').extract())
       

       
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

        print pubItem
       
        spec = { "title": pubItem['title'] }
        computerEngineering.publication.update(spec, {'$set': dict(pubItem)}, upsert=True)
        #computerEngineering.publication.update(spec, {"title_English": pubItem['title_English']}, upsert=False)

from scrapy.spider import Spider
import pymongo
import random
import time
from microAcademic.store import microAcademic
from microAcademic.items import PublicationItem
from scrapy.http import Request
from bson.objectid import ObjectId


class PublicationSpider(Spider):
   name = "publication"
   allowed_domains = ["http://academic.research.microsoft.com"]
   start_urls = []

   basic_url = "http://academic.research.microsoft.com"

   query = {
      "_id" : {"$gte" : ObjectId("54ba0a7a4681ebda8b763f7d") , "$lte" : ObjectId("54ba0ac44681ebda8b763f9a")}
      #"author_name" : "David Cheriton"
      #"_id" : {"$gte" : ObjectId("54ab7b330e3a780ee9765bf1") , "$lte" : ObjectId("54ab7bb60e3a780ee9765bf5")}
      #"_id" : {"$gte" : ObjectId("54ab7bd40e3a780ee9765bf6") , "$lte" : ObjectId("54ab7c740e3a780ee9765bff")}  #41-50
      #"_id" : {"$gte" : ObjectId("54ab7c850e3a780ee9765c00") , "$lte" : ObjectId("54ab7d4f0e3a780ee9765c09")}   #51-60
      #"_id" : {"$gte" : ObjectId("54ab836c0e3a780ee9765c50") , "$lte" : ObjectId("54ab84440e3a780ee9765c59")}   #140
   }
   
   for obj in microAcademic.researcher.find(query):
      if (obj.get('publications_url') != None):
         for start in range(1, 200, 100):
            end = start + 99
            start_urls.append(basic_url + obj.get('publications_url')[5:] + "&start=" + str(start) + "&end=" + str(end))

    
   def parse(self, response):
      #time.sleep(random.random()*3)

      publication_items = response.xpath('//li[@class="paper-item"]')
      for publication_item in publication_items:
         pub_url = "http://academic.research.microsoft.com/" + ''.join(publication_item.xpath('div[1]/div[1]/h3/a/@href').extract())
         yield Request(url=pub_url, callback=self.parse_pubs, dont_filter=True)
   
   def parse_pubs(self, response):
      #time.sleep(random.random()*10)
      
      keywords = []
      keyword_items = response.xpath('//div[@class="left-wrapper"]/div[1]/ul/li')
      for keyword_item in keyword_items:
         keywords.append(''.join(keyword_item.xpath('a/text()').extract()))

      #relates = []
      #relate_items = response.xpath('//div[@class="left-wrapper"]/div[2]/li')
      #for relate_item in relate_items:
         #relates.append(''.join(relate_item.xpath('a/span/text()').extract()))

      title = ''.join(response.xpath('//span[@class="title-span"]/text()').extract())

      authors = []
      author_items = response.xpath('//div[@class="paper-info"]/div[2]/a')
      for author_item in author_items:
         authors.append(''.join(author_item.xpath('text()').extract()))

      abstract = ""
      abstract_items = response.xpath('//span[@id="ctl00_MainContent_PaperItem_snippet"] | //span[@id="ctl00_MainContent_PaperItem_snippet"]/a')
      for abs_item in abstract_items:
         abstract += ''.join(abs_item.xpath('text()').extract()).strip()
      
      doi = ''.join(response.xpath('//a[@id="ctl00_MainContent_PaperItem_hypDOIText"]/text()').extract())


      download_urls = []
      download_items = response.xpath('//table[@id="ctl00_MainContent_PaperItem_downLoadList"]/*')
      for download_item in download_items:
         download_urls.append(''.join(download_item.xpath('td/li/a[2]/@href').extract()))


      provenience = ''.join(response.xpath('//a[@id="ctl00_MainContent_PaperItem_HLConference"]/text() | //a[@id="ctl00_MainContent_PaperItem_HLJournal"]/text()').extract())

      #citations = []
      #citation_items = response.xpath('//li[@class="paper-citation-item"]')
      #for citation_item in citation_items:
         #content = ''.join(citation_item.xpath('/div[1]/ul/li/text()').extract())
         #author = ''.join(citation_item.xpath('/div[1]/h3/a[1]/text()').extract())
         #title = ''.join(citation_item.xpath('/div[1]/h3/a[2]/text()').extract())
         #citations.append({
            #"content" : content,
            #"author" : author,
           # "title" : title
         #})


      pItem = PublicationItem()

      pItem['title'] = title  
      pItem['authors'] = authors
      pItem['publication_url'] = response.url
      pItem['view_url'] = download_urls
      pItem['abstract'] = abstract
      pItem['doi'] = doi
      pItem['keywords'] = keywords
      pItem['provenience'] = provenience

      
      spec = { "title": pItem['title'] }
      microAcademic.publication.update(spec, {'$set': dict(pItem)}, upsert=True)

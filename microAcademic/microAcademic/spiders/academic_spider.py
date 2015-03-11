from scrapy.spider import Spider
import pymongo
import random
import time
from microAcademic.store import microAcademic
from microAcademic.items import ResearcherItem
from scrapy.http import Request

class AcademicSpider(Spider):
   name = "academic"
   allowed_domains = ["http://academic.research.microsoft.com"]
   start_urls = []

   basic_url = "http://academic.research.microsoft.com/RankList?entitytype=2&topDomainID=2&subDomainID=0&&last=0&start="


   for start in range(1, 1200, 100): 
      end = start + 99
      start_urls.append(basic_url + str(start) + "&end=" + str(end))

   def parse(self, response):
      time.sleep(random.random())
      researchers = microAcademic.researchers

      author_items = response.xpath('//div[@class="content-narrow"]')
      
      for author_item in author_items:
         rItem = ResearcherItem()
         author_microurl = ''.join(author_item.xpath('div[1]/h3/a/@href').extract())
         author_name = ''.join(author_item.xpath('div[1]/h3/a/text()').extract())
         author_workplace = ''.join(author_item.xpath('div[2]/a/text()').extract())
         author_picurl = ''.join(author_item.xpath('../div[1]/a/img/@src').extract())
         f_items = author_item.xpath('div[last()-1]/a')
         field = []
         for f_item in f_items:
             field.append(''.join(f_item.xpath('text()').extract()))


         rItem['author_name'] = author_name
         rItem['author_microurl'] = author_microurl
         rItem['author_workplace'] = author_workplace
         rItem['field'] = field
         rItem['author_picurl'] = author_picurl

         yield Request(url=rItem['author_microurl'], meta={'researchItem':rItem}, callback=self.parse_researcher, dont_filter=True)

   def parse_researcher(self, response):

        time.sleep(random.random()*2)
	researchItem = response.meta['researchItem']
	researchItem['homepage'] = ''.join(response.xpath('//div[@class="inline-text card-title"]/div/a[1]/@href').extract())
    	researchItem['publications_url'] = ''.join(response.xpath('//a[@id="ctl00_MainContent_AuthorItem_publication"]/@href').extract())
    	#researchItem['publications_name'] = response.xpath('//div[@class="title-download"]/div/h3/a/text()').extract()
		
	
        spec = { "author_name": researchItem['author_name'] }
        microAcademic.researcher.update(spec, {'$set': dict(researchItem)}, upsert=True)        

# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class ComputerengineeringItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass


class PublicationItem(scrapy.Item):
    authors = scrapy.Field()            #作者们
    title = scrapy.Field()              #论文标题
    
    title_English = scrapy.Field()              #论文标题
    publication_url = scrapy.Field()    #论文url
    view_url = scrapy.Field()           #可以查看完整论文的地址
    keywords = scrapy.Field()           #关键字
    keywords_English = scrapy.Field()
    abstract = scrapy.Field()           #摘要
    abstract_English = scrapy.Field()
    #relates = scrapy.Field()            
    #citations = scrapy.Field()
    doi = scrapy.Field()                #数字对象唯一标识符
    citaarticles = scrapy.Field()         #引用本文

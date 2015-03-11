# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class MicroacademicItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass



class ResearcherItem(scrapy.Item):
    author_name = scrapy.Field()        #作者
    author_microurl = scrapy.Field()    #在微软学术上的主页
    author_workplace = scrapy.Field()   #工作地点
    field = scrapy.Field()              #研究领域
    author_picurl = scrapy.Field()      #个人照片链接
    homepage = scrapy.Field()           #个人主页
    publications_url = scrapy.Field()   #发表论文的统计链接


class PublicationItem(scrapy.Item):
    authors = scrapy.Field()            #作者们
    publication_url = scrapy.Field()    #论文url
    view_url = scrapy.Field()           #可以查看完整论文的地址
    title = scrapy.Field()              #论文标题
    keywords = scrapy.Field()           #关键字
    abstract = scrapy.Field()           #摘要
    #relates = scrapy.Field()            
    #citations = scrapy.Field()
    doi = scrapy.Field()                #数字对象唯一标识符
    provenience = scrapy.Field()         #出处
    

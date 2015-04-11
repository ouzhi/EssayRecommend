# -*- coding: utf-8 -*-

# Scrapy settings for computerEngineering project
#
# For simplicity, this file contains only the most important settings by
# default. All the other settings are documented here:
#
#     http://doc.scrapy.org/en/latest/topics/settings.html
#

BOT_NAME = 'computerEngineering'

SPIDER_MODULES = ['computerEngineering.spiders']
NEWSPIDER_MODULE = 'computerEngineering.spiders'


COOKIES_ENABLED = False
DOWNLOAD_DELAY = 5


# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'computerEngineering (+http://www.yourdomain.com)'


USER_AGENT = 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)'

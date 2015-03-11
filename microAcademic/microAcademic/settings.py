# -*- coding: utf-8 -*-

# Scrapy settings for microAcademic project
#
# For simplicity, this file contains only the most important settings by
# default. All the other settings are documented here:
#
#     http://doc.scrapy.org/en/latest/topics/settings.html
#

BOT_NAME = 'microAcademic'
BOT_VERSION = '1.0'

SPIDER_MODULES = ['microAcademic.spiders']
NEWSPIDER_MODULE = 'microAcademic.spiders'

#RANDOMIZE_DOWNLOAD_DELAY = TRUE
DOWNLOAD_DELAY = 1
COOKIES_ENABLED = False


#USER_AGENT = '%s/%s' % (BOT_NAME, BOT_VERSION)
USER_AGENT = 'Mozilla/5.0 (X11; Linux x86_64; rv:7.0.1) Gecko/20100101 Firefox/7.7'

# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'microAcademic (+http://www.yourdomain.com)'

#encoding: utf-8
import pymongo
import random
HOST = "127.0.0.1"
PORT = 27017

client = pymongo.MongoClient(HOST, PORT)

computerEngineering = client.computerEngineering

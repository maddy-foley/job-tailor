import sqlite3
from sqlalchemy import create_engine, MetaData
from sqlalchemy.orm import Session
from models import *
import logging

engine = create_engine("sqlite:///database/sqlite.db",echo=True)

logging.basicConfig()
logging.getLogger("sqlalchemy.dialects.sqlite").setLevel(logging.INFO)

def create_tables():
    Base.metadata.create_all(engine)
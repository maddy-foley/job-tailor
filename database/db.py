import sqlite3
from sqlalchemy import create_engine, MetaData, select
from sqlalchemy.orm import Session
from common_models import *
from application_models import *
from candidate_models import * 
import logging
from example_data import my_info


engine = create_engine("sqlite:///database/sqlite.db",echo=True)

logging.basicConfig()
logging.getLogger("sqlalchemy.dialects.sqlite").setLevel(logging.INFO)

def create_tables():
    Base.metadata.create_all(engine)

# add a way to check first
def add_candidate_info(candidate_info: dict):
    with Session(engine) as session:
        candidate = Candidate(
            first_name=candidate_info.get('first_name'),
            last_name=candidate_info.get('last_name'),
            date_created=candidate_info.get('date_created'),
            address=candidate_info.get('address')
        )

        session.add(candidate)
        session.commit()

def get_candidate_info():
    session = Session(engine)
    stmt = select(Candidate)
    for c in session.scalars(stmt):
        print(c.first_name)
# create_tables()
# add_candidate_info(my_info)
get_candidate_info()
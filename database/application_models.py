from common_models import Base
from typing import List, Optional
from datetime import datetime
from sqlalchemy import ForeignKey, Text, DateTime, Integer, Table, Column, Enum
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship
import enum
from common_models import Skill, Base
from candidate_models import Candidate




class Status(enum.Enum):
    SAVED = "saved"
    APPLIED = "applied"
    INTERVIEWING = "interviewing"
    OFFERED = "offered"
    REJECTED = "rejected"
    

class Application(Base):
    __tablename__ = "application"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)
    company: Mapped[str] = mapped_column(Text)
    date_created: Mapped[datetime] = mapped_column(DateTime)
    date_updated: Mapped[Optional[datetime]] = mapped_column(DateTime)
    job_post: Mapped[Optional[str]] = mapped_column(Text)
    candidate_id: Mapped[int] = mapped_column(ForeignKey("candidate.id"))
    candidate: Mapped["Candidate"] = relationship(
        back_populates="candidate", cascade="all, delete-orphan"
    )
    status: Mapped[Status] = mapped_column(Integer, default=0)
    notes: Mapped[Optional[str]] = mapped_column(Text)
    skills: Mapped[List["ApplicationSkill"]] = relationship(
        back_populates="skill"
    )

class ApplicationSkill(Base):

    __tablename__ = "application_skill"
    skill_id: Mapped[int] = mapped_column(ForeignKey("skill.id"), primary_key=True)
    application_id: Mapped[int] = mapped_column(
        ForeignKey("application.id"), primary_key=True
    )
    application: Mapped["Application"] = relationship(back_populates="application")
    skill: Mapped["Skill"] = relationship(back_populates="skill")
    ability: Mapped[Optional[int]] = mapped_column(Integer)
    yoe: Mapped[Optional[int]] = mapped_column(Integer)
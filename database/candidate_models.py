from common_models import Base
from typing import List, Optional
from datetime import datetime
from sqlalchemy import ForeignKey, Text, DateTime, Integer, Table, Column, Enum
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship
import enum
from common_models import Skill, Base

class Address(Base):
    __tablename__ = "address"

    id: Mapped[int] = mapped_column(primary_key=True)
    email: Mapped[str] = mapped_column(Text)
    phone: Mapped[str] = mapped_column(Text)
    street: Mapped[str] = mapped_column(Text)
    country: Mapped[str] = mapped_column(Text)
    zip_code: Mapped[int] = mapped_column(Integer)
    state: Mapped[str] = mapped_column(Text)
    city: Mapped[str] = mapped_column(Text)
    candidate_id: Mapped[int] = mapped_column(ForeignKey("candidate.id"))
    candidate: Mapped["Candidate"] = relationship(
        back_populates="candidate", cascade="all, delete-orphan"
    )

class Candidate(Base):
    __tablename__ = "candidate"

    id: Mapped[int] = mapped_column(primary_key=True)
    first_name: Mapped[str] = mapped_column(Text)
    last_name: Mapped[str] = mapped_column(Text)
    date_created: Mapped[datetime] = mapped_column(DateTime)
    date_updated: Mapped[datetime] = mapped_column(DateTime)
    address: Mapped["Address"] = relationship(
        back_populates="candidate", cascade="all, delete-orphan"
    )
    skills: Mapped[List["CandidateSkill"]] = relationship(back_populates="candidate")

class CandidateSkill(Base):
    __tablename__ = "candidate_skill"

    skill_id: Mapped[int] = mapped_column(ForeignKey("skill.id"), primary_key=True)
    candidate_id: Mapped[int] = mapped_column(
        ForeignKey("candidate.id"), primary_key=True
    )
    
    candidate: Mapped["Candidate"] = relationship(back_populates="candidate")
    skill: Mapped["Skill"] = relationship(back_populates="skill")
    ability: Mapped[Optional[int]] = mapped_column(Integer)
    yoe: Mapped[Optional[int]] = mapped_column(Integer)


class Experience(Base):
    __tablename__ = "experience"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)
    description: Mapped[str] = mapped_column(Text)
    start_date: Mapped[datetime] = mapped_column(DateTime)
    end_date: Mapped[Optional[datetime]] = mapped_column(DateTime)
    experience_type_id: Mapped[int] = mapped_column(ForeignKey("experience_type.id"))
    experience_type: Mapped[List["ExperienceType"]] = relationship(
        back_populates="experience_type", cascade="all, delete-orphan"
    )
    accomplishment: Mapped[List["Accomplishment"]] = relationship(
        back_populates="accomplishment", cascade="all, delete-orphan"
    )

class ExperienceType(Base):
    __tablename__ = "experience_type"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)

class Accomplishment(Base):
    __tablename__ = "accomplishment"

    id: Mapped[int] = mapped_column(primary_key=True)
    description: Mapped[str] = mapped_column(Text)
    experience_id: Mapped[int] = mapped_column(ForeignKey("experience.id"))
    experience: Mapped["Experience"] = relationship(
        back_populates="experience"
    )
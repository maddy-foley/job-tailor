from typing import List, Optional
from datetime import datetime
from sqlalchemy import ForeignKey, Text, DateTime, Integer, Table, Column
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship



class Base(DeclarativeBase):
    pass


skill_category = Table(
    "skill_category",
    Base.metadata,
    Column("skill_id", ForeignKey("skill.id")),
    Column("category_id", ForeignKey("category.id")),
)

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
    candidate_id: Mapped[int] = mapped_column(ForeignKey("candidate_profile.id"))
    candidate: Mapped["CandidateProfile"] = relationship(
        back_populates="candidate", cascade="all, delete-orphan"
    )


class CandidateProfile(Base):
    __tablename__ = "candidate_profile"

    id: Mapped[int] = mapped_column(primary_key=True)
    first_name: Mapped[str] = mapped_column(Text)
    last_name: Mapped[str] = mapped_column(Text)
    date_created: Mapped[datetime] = mapped_column(DateTime)
    date_updated: Mapped[datetime] = mapped_column(DateTime)
    address: Mapped["Address"] = relationship(
        back_populates="candidate", cascade="all, delete-orphan"
    )
    skills: Mapped[List["Skill"]] = relationship(
        back_populates="skill", cascade="all, delete-orphan"
    )

class Skill(Base):
    __tablename__ = "skill"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)
    ability: Mapped[int] = mapped_column(Integer)
    yoe: Mapped[int] = mapped_column(Integer)
    candidate_id: Mapped[int] = mapped_column(ForeignKey("candidate_profile.id"))
    categories: Mapped[List["Category"]] = relationship(
        secondary=skill_category,
        back_populates="category"
    )

class Category(Base):
    __tablename__ = "category"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)
    skills: Mapped[List["Skill"]] = relationship(
        secondary=skill_category,
        back_populates="skill"
    )



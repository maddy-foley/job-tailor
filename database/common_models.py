from typing import List, Optional
from datetime import datetime
from sqlalchemy import ForeignKey, Text, DateTime, Integer, Table, Column, Enum
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship
import enum


class Base(DeclarativeBase):
    pass


class Skill(Base):
    __tablename__ = "skill"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)
    categories: Mapped[List["SkillCategory"]] = relationship(back_populates="skill")

class Category(Base):
    __tablename__ = "category"

    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(Text)

    skills: Mapped[List["SkillCategory"]] = relationship(back_populates="category")


class SkillCategory(Base):
    __tablename__ = "skill_category"

    skill_id: Mapped[int] = mapped_column(ForeignKey("skill.id"), primary_key=True)
    category_id: Mapped[int] = mapped_column(
        ForeignKey("category.id"), primary_key=True
    )
    skill: Mapped["Skill"] = relationship(back_populates="categories")
    category: Mapped["Category"] = relationship(back_populates="skills")
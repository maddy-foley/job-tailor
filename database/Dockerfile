FROM postgres:latest

ENV POSTGRES_DB mydb;

COPY ./scripts/ /docker-entrypoint-initdb.d/

EXPOSE 5432
Need to add required fields to tables

Need to insert starting data

review cascade deletes

- skills fks needs review


Docker container test commands:
```
 docker build -t my-postgres-image .  


docker run --name my-postgres-container \
-e POSTGRES_USER=myuser \
-e POSTGRES_PASSWORD=mypassword \
-e POSTGRES_DB=mydb \
-p 5432:5432 \
-d my-postgres-image
```

exec command for opening postgres in docker:
```
psql -h localhost -U myuser -d mydb
```
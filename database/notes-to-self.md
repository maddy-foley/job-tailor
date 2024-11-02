Need to add required fields to tables

Need to insert starting data

review cascade deletes

- skills fks needs review


Docker container test commands:
```
 docker build -t my-test .  


docker run --name my-postgres-container \
-e POSTGRES_USER=myuser \
-e POSTGRES_PASSWORD=mypassword \
-e POSTGRES_DB=mydb \
--network mynetwork \
-p 5432:5432 \
-d my-test
```

add ```--network my network``` and ddl = update on spring to communicate

exec command for opening postgres in docker:
```
psql -h localhost -U myuser -d mydb
```

 CURRENTLY CASCADES ARE WRONG - double check!
#!/bin/sh

docker stop;
docker compose down -v;
docker rmi $(docker images -aq)
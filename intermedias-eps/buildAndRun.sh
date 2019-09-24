#!/bin/sh
mvn clean package && docker build -t com.practicas/intermedias-eps .
docker rm -f intermedias-eps || true && docker run -d -p 8080:8080 -p 4848:4848 --name intermedias-eps com.practicas/intermedias-eps 

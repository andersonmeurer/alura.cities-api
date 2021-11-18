#Criar aplicacao spring initializer
##Dependencias:
hibernate-types-52
postgresql
spring-boot-starter-web
spring-boot-starter-data-jpa

#Criar banco da dados PG
Postgres Docker Hub
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

#Popular dados no banco escolhido encontrados em:
https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL

#Pesquisa paginada
//http://localhost:8080/countries?page=0&size=10&sort=name,asc
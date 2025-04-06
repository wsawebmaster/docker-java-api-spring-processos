# 📂 Desenvolvendo uma API com Spring Boot

## 📃 API para gerenciamento de processos

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- Liquibase
- Hibernate
- Junit
- Docker
- Docker compose
- Insomnia
- Extensão SQL Server Client no VsCode, Dbeaver ou outro software de sua preferência


## Subir PostgreSQL via Docker Compose

    docker compose up -d

### Comandos de instalar dependências e executar o projeto

    mvn clean spring-boot:run

### Comandos úteis para instalar e selecionar versão do Java

    sudo apt install openjdk-17-jdk
    
    sudo update-alternatives --config java

## Remover contêineres, imagens e limpar redes não utilizadas.

    [ "$(docker ps -q)" ] && docker stop $(docker ps -q); [ "$(docker ps -aq)" ] && docker rm $(docker ps -aq); [ "$(docker images -q)" ] && docker rmi $(docker images -q); docker network prune -f

## Endpoints da API

- `POST` Cadastrar Processo `http://localhost:8080/processos`

        {
            "numero": 1
        }

- `POST` Adicionar réu a um processo `http://localhost:8080/processos/id/reus`

        {
            "nome": "Nome do Réu"
        }

- `GET` Listar todos os processos: `http://localhost:8080/processos`
- `GET` Listar um processo: `http://localhost:8080/processos/id`
- `PUT` Atualizar um processo: `http://localhost:8080/processos/id`

        {
            "numero": 7
        }

- `DELETE` Excluir um processo: `http://localhost:8080/processos/id`

![MER](/image.jpg "Imagem dos Endpoins pelo Insomnia")

## Links uteis

* [SpringInitializr](https://start.spring.io/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.4/maven-plugin)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.4/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.4/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Liquibase Migration](https://docs.spring.io/spring-boot/3.4.4/how-to/data-initialization.html#howto.data-initialization.migration-tool.liquibase)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.4/reference/using/devtools.html)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

---
---

## 📧 Contato

[LinkedIn](https://www.linkedin.com/in/wsawebmaster/)

[wsawebmaster@yahoo.com.br](mailto:wsawebmaster@yahoo.com.br)
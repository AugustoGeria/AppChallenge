# Application challenge

Application challenge is a web application based on microservices that runs in Docker containers. This README provides instructions for installing and running.

## Prerequisites

Make sure you have the following components installed on your system:

- Docker: [https://www.docker.com](https://www.docker.com)

## Installation Steps

Follow the steps below to install and run Application  challenge in your local environment:

1. To build the Docker image navigate to the root directory of the project and enter:

   ```shell
   docker build -t spring-boot-docker .

2. Run the following command to start the containers:

    ```shell
   docker run --name MyContainerSB --publish 8080:8080 spring-boot-docker

This command will download the necessary images, create and run the containers based on the configuration specified in the Dockerfile file.

3. After the containers have started successfully, you can access to Swagger Documentation through your web browser at the following URL:


         http://localhost:8080/swagger-ui.html

## Relevant Information
1. Get a Token

         POST http://localhost:8080/auth/login
         
         body:
              {
                  "username": "test",
                  "password": "12345"
              }

2. The scripts are located in resources/data.sql. These will run automatically when the application starts.


3. To access the H2 console through your web browser at the following URL:


         http://localhost:8080/h2-console

         User Name: sa
         Password: password

## Technologies

- Spring boot
- Maven
- Spring Security
- H2
- Lombok
- Swagger
- Docker
Customer manager Service

1. Requirements
   For building and running the application you need:

   - Java 17
   - Maven 3.6.3

2. Running the application locally

   There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.pje.testapp.customer.CustomerAPpliccation class from your IDE.

   Alternatively you can use the Spring Boot Maven plugin like so:

   'mvn spring-boot:run'

   e.g endpoints

   - POST http://localhost:8080/api/create
   - GET http://localhost:8080/api/fetch?customerReferance=PJE

3. Running a docker container

   - get docker image from docker hub - 'docker pull pjedhe/customer'
   - start docker container - 'docker run -p 8080:8080 pjedhe/customer:v1'

4. API Documentation can be accessed as a swagger document

   - /swagger-ui/index.html

5. Database - Data is stored in h2 relational DB
   - /h2-console
   - userrname 'sa'

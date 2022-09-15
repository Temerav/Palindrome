#Requirements

For building and running application you need:

* JDK 11
* Maven 3.6.3
* IntelliJ
* PostgreSQL 14

#Running the application locally

You can start JuniortestApplication, this is the main method, or
you can start with Spring Boot Maven plugin: 
* ``mvn clean spring-boot:run``

Alternatively, you can package the application in the form of a JAR file and then run:
* ``mvn clean package ``
* ``java -jar target/spring-boot-postgresql-0.0.1-SNAPSHOT.jar``
* The application will start on the port 8090.

#Configure PostgreSQL

* First, create a database named postgres_demo. 
* Then, open src/main/resources/application.properties file
* Change the spring datasource to your new local database.


#Api Requests
How to test the APIs using Postman:

* GET http://localhost:8090/api/v1/palindrome
* POST http://localhost:8090/api/v1/palindrome
* DELETE http://localhost:8090/api/v1/palindrome/<id_here>
* PUT http://localhost:8090/api/v1/palindrome/<id_here>?content=<new_content>


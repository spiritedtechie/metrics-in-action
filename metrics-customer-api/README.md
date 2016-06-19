Description
-----------

This is a basic REST API for storing and retrieving customers.

It shows the Metrics library, which has been used to annotate key methods (resource and service) to collect runtime operational metrics. 

It also meters exceptions, and instruments the HTTP client to show size of connection pool and rate are which HTTP connections are opened.

The application is built using Spring Boot with JAX-RS (Jersey).

Setup
-----

1) Ensure the Address lookup stub is running. Follow README for external-http-service-stub.

2) Build the application

    ./gradlew clean build

3) Run the Spring Boot application from the project root

    java -jar build/libs/metrics-customer-api-1.0.jar
    
It runs on the default port 8080.

API Usage
---------

###### To get the default customer by ID

GET http://localhost:8080/customers/1

###### To create a new customer

POST http://localhost:8080/customers

    ContentType: application/xml
    <customer>
        <id>2</id>
        <firstName>John</firstName>
        <lastName>Doe</lastName>
    </customer>

    ContentType: application/json
    {
        "id": "2",
        "firstName": "John",
        "lastName": "Doe"
    }

###### To check the external HTTP service stub is deployed

GET http://localhost:8082/address

###### To get the metrics in JSON form

GET http://localhost:8080/metrics

Setup
-----

1) Ensure the Address lookup stub is running. Follow README instructions in folder.

2) Build the application

    ./gradlew clean build

3) Run the Spring Boot application from the project root

    java -jar build/libs/metrics-customer-api-1.0.jar

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

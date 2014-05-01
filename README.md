metrics-in-action
=================

Example of using the metrics library in a JAX-RS, RESTEasy and Spring service. Utilising the following metrics libraries:

1. metrics-annotation : for annotating JAX-RS resource methods and other functions with metrics annotations
2. metrics-spring: for scanning and loading metrics annotated Spring components into the metric registry, and loading healthchecks into the healthcheck registry
3. metrics-servlet: for instrumenting servlet calls using an instrumented filter
4. metrics-servlets: for providing reporting servlets over the metric & health check registries
5. metrics-httpclient: for use of an instrumented http client for downstream http calls
6. metrics watcher : some HTML, CSS and JS for visualising some of the metrics produced by the metrics-servlets.

Instructions
------------
To get it running:

1. Install JBoss 7/EAP on localhost

2. Start a standalone instance of JBoss

    ./bin/standalone.sh -b 0.0.0.0
    
3. Build the HTTP service stub

    mvn clean package
    
4. Deploy the HTTP service stub to standalone deployments folder

5. Build the metrics-customer-api

    mvn clean package

6. Deploy the metrics-customer-api WAR to standalone deployments folder

7. POST a customer via a REST client to

    http://localhost:8080/metrics-customer-api/api/customers

    Content-Type header: application/json

    {
        "id": "2",
        "firstName": "John",
        "lastName": "Doe"
    }

8. GET a customer via a REST client
  
    http://localhost:8080/metrics-customer-api/api/customers/1

9. Visit the metrics admin page and check the metrics, ping and health check sub-links all work
  
    http://localhost:8080/metrics-customer-api/ops

10. Visit the prettier metrics watcher page:

    http://localhost:8080/metrics-customer-api/
   

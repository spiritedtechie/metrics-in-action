Description
-----------

This is a simple stub REST service that returns an fixed address.

It is used by the customer API to show how the HTTP client (client side) can be instrumented by Metrics HTTP.

This service is build using Dropwizard and JAX-RS.

Setup
-----

1) Run the Address Lookup stub service

    ./gradlew run
  
It runs on port 8082 (as configured in local.yml)

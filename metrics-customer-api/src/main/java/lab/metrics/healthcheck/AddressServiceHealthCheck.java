package lab.metrics.healthcheck;

import lab.http.HttpFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.health.HealthCheck;

@Component
public class AddressServiceHealthCheck extends HealthCheck {

    private final HttpFactory httpFactory;

    @Autowired
    public AddressServiceHealthCheck(HttpFactory fact) {
        httpFactory = fact;
    }

    @Override
    protected Result check() throws Exception {
        final HttpClient http = httpFactory.getHttp();
        final HttpGet httpget = new HttpGet("http://localhost:8080/http-service-stub/ping");

        HttpResponse resp = http.execute(httpget);

        if (resp == null || resp.getStatusLine().getStatusCode() != 200) return Result
                .unhealthy("Could not ping address service" + resp.getStatusLine().getStatusCode());
        else return Result.healthy("Successfully pinged address service");

    }

}

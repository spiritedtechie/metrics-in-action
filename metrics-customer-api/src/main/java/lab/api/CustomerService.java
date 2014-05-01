package lab.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab.http.HttpFactory;
import lab.model.Customer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.annotation.Timed;

@Component
public class CustomerService {

    private static final Log LOG = LogFactory.getLog(CustomerResource.class);

    private final Map<String, Customer> customerMap = Collections.synchronizedMap(new HashMap<String, Customer>());

    private HttpFactory httpFactory;

    @Autowired
    public CustomerService(HttpFactory fact) {
        this.httpFactory = fact;

        createDefaultCustomer();
    }

    public CustomerService() {
    }

    public Customer newCustomer(final Customer customer) {
        if (customerMap.containsKey(customer.getId()))
            throw new IllegalArgumentException("Customer already exists for id: " + customer.getId());

        if (customer.getAddress() == null) {
            final String address = findAddressInformation();
            customer.setAddress(address);
        }

        customerMap.put(customer.getId(), customer);
        LOG.debug("Customer map: " + customerMap);

        return customer;
    }

    @Timed(name = "find-customer-timed")
    public Customer findCustomer(final String customerId) {
        return customerMap.get(customerId);
    }

    private String findAddressInformation() {
        final HttpClient http = httpFactory.getHttp();
        final HttpGet httpget = new HttpGet("http://localhost:8080/http-service-stub/address");

        HttpResponse resp;
        try {
            resp = http.execute(httpget);
        } catch (final Exception e) {
            throw new RuntimeException("Unable to call address service", e);
        }

        return extractAddressLine(resp);
    }

    private String extractAddressLine(HttpResponse resp) {
        if (resp != null && resp.getStatusLine().getStatusCode() == 200) {
            try {
                return IOUtils.toString(resp.getEntity().getContent());
            } catch (final Exception e) {
                throw new RuntimeException("Unable to extract customer address from response", e);
            }
        } else throw new RuntimeException("Invalid response from address service: "
                + resp.getStatusLine().getStatusCode());
    }

    private void createDefaultCustomer() {
        final Customer c1 = new Customer();
        c1.setId("1");
        c1.setFirstName("Bob");
        c1.setLastName("Brown");
        c1.setAddress("27 Coventry Street");

        customerMap.put(c1.getId(), c1);
    }

}

package lab;

import lab.api.CustomerResource;
import lab.api.MetricsResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(CustomerResource.class);
        register(MetricsResource.class);
    }

}

package lab.api;

import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/metrics")
public class MetricsResource {

    @Autowired
    private MetricRegistry registry;

    public MetricsResource() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public MetricRegistry getMetrics() {
        return registry;
    }

}

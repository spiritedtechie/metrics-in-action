package lab.metrics.registry;

import com.codahale.metrics.health.HealthCheckRegistry;

public class MyHealthCheckRegistry extends HealthCheckRegistry {

    private static final HealthCheckRegistry registry = new MyHealthCheckRegistry();

    private MyHealthCheckRegistry() {
    }

    public static HealthCheckRegistry getRegistry() {
        return registry;
    }
}

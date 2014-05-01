package lab.metrics.registry;

import com.codahale.metrics.MetricRegistry;

public class MyMetricRegistry extends MetricRegistry {

    private static final MetricRegistry registry = new MyMetricRegistry();

    private MyMetricRegistry() {
    }

    public static MetricRegistry getRegistry() {
        return registry;
    }

}

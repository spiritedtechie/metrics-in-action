package lab.metrics.web;

import javax.servlet.annotation.WebListener;

import lab.metrics.registry.MyMetricRegistry;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;

@WebListener
public class MyInstrumentedFilterContextListener extends InstrumentedFilterContextListener {

    @Override
    protected MetricRegistry getMetricRegistry() {
        return MyMetricRegistry.getRegistry();
    }

}

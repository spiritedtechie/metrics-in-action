package lab.metrics.web.servlets;

import javax.servlet.annotation.WebListener;

import lab.metrics.registry.MyMetricRegistry;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;

@WebListener
public class MyMetricsServletContextListener extends MetricsServlet.ContextListener {

    @Override
    protected MetricRegistry getMetricRegistry() {
        return MyMetricRegistry.getRegistry();
    }

}

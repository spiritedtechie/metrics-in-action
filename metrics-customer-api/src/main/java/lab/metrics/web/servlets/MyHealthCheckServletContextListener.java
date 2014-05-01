package lab.metrics.web.servlets;

import javax.servlet.annotation.WebListener;

import lab.metrics.registry.MyHealthCheckRegistry;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

@WebListener
public class MyHealthCheckServletContextListener extends HealthCheckServlet.ContextListener {

    @Override
    protected HealthCheckRegistry getHealthCheckRegistry() {
        return MyHealthCheckRegistry.getRegistry();
    }

}

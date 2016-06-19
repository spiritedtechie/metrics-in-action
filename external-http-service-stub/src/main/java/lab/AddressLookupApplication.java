package lab;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lab.resources.AddressResource;

public class AddressLookupApplication extends Application<AddressLookupAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new AddressLookupApplication().run(args);
    }

    @Override
    public String getName() {
        return "address-lookup-app";
    }

    @Override
    public void initialize(Bootstrap<AddressLookupAppConfiguration> bootstrap) {
    }

    @Override
    public void run(AddressLookupAppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new AddressResource());
    }

}
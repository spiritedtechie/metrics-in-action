package lab.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customers {

    private List<Customer> customers = new ArrayList<Customer>();

    @XmlElementWrapper(name = "list")
    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(final List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(final Customer customer) {
        customers.add(customer);
    }

}

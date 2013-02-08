package lab.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private String id;

    private String firstName;

    private String lastName;

    private String address;

    private boolean isVulnerable = false;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public boolean isVulnerable() {
        return isVulnerable;
    }

    public void setVulnerable(final boolean isVulnerable) {
        this.isVulnerable = isVulnerable;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
                + ", vulnerable=" + isVulnerable + "]";
    }

}

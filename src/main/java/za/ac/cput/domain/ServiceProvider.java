package za.ac.cput.domain;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class ServiceProvider {
    @Id
    private String providerId;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceCode", referencedColumnName = "serviceCode")
    private Service service;

    protected ServiceProvider() {
    }

    public ServiceProvider(Builder builder) {
        this.providerId = builder.providerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
        this.service = builder.service;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public Service getService() {
        return service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceProvider that)) return false;
        return Objects.equals(providerId, that.providerId) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getContact(), that.getContact()) &&
                Objects.equals(getService(), that.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, getFirstName(), getLastName(), getContact(), getService());
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "providerId='" + providerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                ", service=" + service +
                '}';
    }

    public static class Builder {
        private String providerId;
        private String firstName;
        private String lastName;
        private Contact contact;
        private Service service;

        public Builder setProviderId(String providerId) {
            this.providerId = providerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setService(Service service) {
            this.service = service;
            return this;
        }

        public Builder copy(ServiceProvider sp) {
            this.providerId = sp.providerId;
            this.firstName = sp.firstName;
            this.lastName = sp.lastName;
            this.contact = sp.contact;
            this.service = sp.service;
            return this;
        }

        public ServiceProvider build() {
            return new ServiceProvider(this);
        }
    }
}

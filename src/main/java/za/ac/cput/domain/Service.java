package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceCode;
    private String serviceName;
    private String womensServiceDescription; // Retained only women's service description
    private double price;

    public Service() {
    }

    public Service(Builder builder) {
        this.serviceCode = builder.serviceCode;
        this.serviceName = builder.serviceName;
        this.womensServiceDescription = builder.womensServiceDescription; // Retained
        this.price = builder.price;
    }

    public Long getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Long serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getWomensServiceDescription() { // Only women's service description
        return womensServiceDescription;
    }

    public void setWomensServiceDescription(String womensServiceDescription) {
        this.womensServiceDescription = womensServiceDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Double.compare(service.price, price) == 0 &&
                Objects.equals(serviceCode, service.serviceCode) &&
                Objects.equals(serviceName, service.serviceName) &&
                Objects.equals(womensServiceDescription, service.womensServiceDescription); // Updated
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCode, serviceName, womensServiceDescription, price); // Updated
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceCode=" + serviceCode +
                ", serviceName='" + serviceName + '\'' +
                ", womensServiceDescription='" + womensServiceDescription + '\'' + // Updated
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long serviceCode;
        private String serviceName;
        private String womensServiceDescription; // Retained only women's service description
        private double price;

        public Builder setServiceCode(Long serviceCode) {
            this.serviceCode = serviceCode;
            return this;
        }

        public Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder setWomensServiceDescription(String womensServiceDescription) { // Retained
            this.womensServiceDescription = womensServiceDescription;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Service service) {
            this.serviceCode = service.serviceCode;
            this.serviceName = service.serviceName;
            this.womensServiceDescription = service.womensServiceDescription; // Retained
            this.price = service.price;
            return this;
        }

        public Service build() {
            return new Service(this);
        }
    }
}

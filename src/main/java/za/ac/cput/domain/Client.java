package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

/*
Likhona Nxusani
 */
@Entity
public class Client {
    @Id
    private String clientId;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Contact contact;

    protected Client(){
    }

    public Client(Builder builder){
        this.clientId = builder.clientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
    }

    public String getClientId() {
        return clientId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getClientId(), client.getClientId()) && Objects.equals(getFirstName(), client.getFirstName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getContact(), client.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getFirstName(), getLastName(), getContact());
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private String clientId;
        private String firstName;
        private String lastName;
        private Contact contact;

        public Builder setClientId(String clientId) {
            this.clientId = clientId;
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

        public Builder copy(Client client){
            this.clientId = client.clientId;
            this.firstName = client.firstName;
            this.lastName = client.lastName;
            this.contact = client.contact;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }
}

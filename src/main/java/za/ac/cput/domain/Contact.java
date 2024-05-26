package za.ac.cput.domain;
//218130260AZJoka

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;
@Entity
public class Contact  {
    @Id
    private String email;
    private String mobileNumber;
    private String workTelephone;

    protected Contact() {
    }
    private Contact(Builder builder){
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.workTelephone = builder.workTelephone;

    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobileNumber, contact.mobileNumber) && Objects.equals(workTelephone, contact.workTelephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobileNumber, workTelephone);
    }

    public static class Builder {
        private String email;
        private String mobileNumber;
        private String workTelephone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setWorkTelephone(String workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }
        public Builder copy(Contact contact){
            this.email =contact.email;
            this.mobileNumber = contact.mobileNumber;
            this.workTelephone =contact.workTelephone;
            return this;

        }
        public Contact build() {
            return new Contact(this);
        }
    }


}



package za.ac.cput.domain;

/*
 Aphelele Zimkhita Joka 218130260
 */

import jakarta.persistence.*;

import java.util.Objects;
/*
@Entity
public class Employee {

    @Id
    private int employeeID; // Changed to int
    private String firstName;
    private String lastName;
    private String jobPosition; // Removed userName
    private String password;
    private boolean success;
    private String message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;

    protected Employee() {
    }

    private Employee(Builder builder) {
        this.employeeID = builder.employeeID; // Changed from String to int
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.jobPosition = builder.jobPosition; // Updated to reflect removal
        this.password = builder.password;
        this.success = builder.success;
        this.message = builder.message;
        contact = builder.contact;
    }

    public Employee(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public int getEmployeeID() { // Changed return type from String to int
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobPosition() { // Updated to reflect removal of userName
        return jobPosition;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return success == employee.success &&
                employeeID == employee.employeeID && // Updated comparison
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(jobPosition, employee.jobPosition) && // Updated to reflect removal of userName
                Objects.equals(password, employee.password) &&
                Objects.equals(message, employee.message) &&
                Objects.equals(contact, employee.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName, jobPosition, password, success, message, contact); // Updated to reflect removal of userName
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID + // Updated to reflect int
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobPosition='" + jobPosition + '\'' + // Updated to reflect removal of userName
                ", password='" + password + '\'' +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private int employeeID; // Changed from String to int
        private String firstName;
        private String lastName;
        private String jobPosition; // Removed userName
        private String password;
        private boolean success;
        private String message;
        private Contact contact;

        public Builder setEmployeeID(int employeeID) { // Changed parameter type from String to int
            this.employeeID = employeeID; // Updated to reflect int
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

        public Builder setJobPosition(String jobPosition) { // Updated to reflect removal of userName
            this.jobPosition = jobPosition;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeID = employee.employeeID; // Updated to reflect int
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.jobPosition = employee.jobPosition; // Updated to reflect removal of userName
            this.password = employee.password;
            this.contact = employee.contact;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

*/
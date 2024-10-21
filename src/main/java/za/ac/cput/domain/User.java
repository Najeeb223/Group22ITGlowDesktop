package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class User {

    @Id
    @Column(name = "email", unique = true)  // Making email unique to avoid duplicates
    private String email;                   // Email is used as the username

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;


    protected User() {
    }

    public User(String email) {
        this.email = email;
    }

    private User(Builder builder) {
        email = builder.email;              // Email replaces username as the identifier
        name = builder.name;
        surname = builder.surname;
        password = builder.password;
        roles = builder.roles;
    }

    // Builder class for User construction
    public static class Builder {
        private String email;
        private String name;
        private String surname;
        private String password;
        private List<Role> roles;

        public Builder setEmail(String email) {  // Set email as the primary identifier
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRoles(List<Role> roles) {
            this.roles = roles;
            return this;
        }
        public String getPassword(){

            return password;
        }
        public Builder copy(User user) {
            this.email = user.email;  // Copy email instead of username
            this.name = user.name;
            this.surname = user.surname;
            this.password = user.password;
            this.roles = user.roles;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

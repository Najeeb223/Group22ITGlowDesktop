package za.ac.cput.factory;


import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.util.List;

public class UserFactory {

    public static User buildUser(String username, String name, String surname, String email, String password, List<Role> roles) {

        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(String.valueOf(roles))){
            return null;
        }

        return new User.Builder()
                //.setEmail(username)
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPassword(password)
                .setRoles(roles)
                .build();
    }
}


package za.ac.cput.serviceTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static User user1;
    private static User user2;
    //private List<Role>roles;


    @BeforeEach
    void setup() {

        Role userRole = new Role("USER");
        List<Role> roles = Collections.emptyList();
        user1 = UserFactory.buildUser("Gil722", "Abdul",
                "Gilbert", "abzgil@gmail.com", "47792qh",roles);
        assertNotNull(user1);
        System.out.println(user1);

        user2 = UserFactory.buildUser("Meer521",
                "Ameer", "Patel", "APatel@gmail.com", "8022wes",roles);
        assertNotNull(user2);
        System.out.println(user2);
    }

    @Test
    void b_create() {
        User created1 = userService.create(user1);
        assertNotNull(created1);
        System.out.println(created1);
        User created2 = userService.create(user2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        User read = userService.read(user1.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        User newUser = new User.Builder().copy(user1).setName("Abdul Hashim").build();
        User updated = userService.update(newUser);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_getAll() {
        System.out.println(userService.getAll());
    }
}


package za.ac.cput.factoryTest;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void testBuildUserWithValidEmail() {
        Role userRole = new Role("USER");
        List<Role> roles = Collections.singletonList(userRole);
        User u1 = UserFactory.buildUser("saidit22", "Tony", "Saidi",
                "TonySaidi@gmail.com", "zheope",roles);
        assertNotNull(u1);
        System.out.println(u1);
    }

    @Test
    void testBuildUserWithInvalidEmail() {
        Role userRole = new Role("ADMIN");
        List<Role> roles = Collections.singletonList(userRole);
        User u2 = UserFactory.buildUser("saidit22", "Tony",
                "Saidi", "", "zheope",roles);
        assertNull(u2);
        System.out.println(u2);
    }
}

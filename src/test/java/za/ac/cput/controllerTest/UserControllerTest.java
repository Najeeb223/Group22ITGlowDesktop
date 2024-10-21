package za.ac.cput.controllerTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8081/ITGlowMobileApp/user";

    private static User user;

    @BeforeAll
    public static void setUp() {
        Role userRole = new Role("USER");
        List<Role> roles = Collections.emptyList(); // Or however you intend to set up roles
        user = UserFactory.buildUser("Waleed88", "Waleed",
                "Mohammed", "waleedmo@gmail.com", "walmozh9987", roles);
    }


    @Test
    void a_create() {
        String URL = BASE_URL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(
                "/user", user,User.class);
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User userSaved = postResponse.getBody();
        assertEquals(user.getEmail(), userSaved.getEmail());
        System.out.println("Created User: " + userSaved);
    }

    @Test
    void b_read() {
        String URL = BASE_URL + "/read" + user.getEmail();
        System.out.println("URL: " + URL);
        ResponseEntity<User> response = restTemplate.getForEntity(URL, User.class);
        assertNotNull(response.getBody());
        System.out.println("Read User: " + response.getBody());
        assertEquals(user.getEmail(), response.getBody().getEmail());
    }

    @Test
    void c_update() {
        String URL = BASE_URL + "/update";
        User newUser = new User.Builder().copy(user).setName("Waleed Karim").build();
        ResponseEntity<User> postResponse = restTemplate.postForEntity(URL, newUser, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User userUpdated = postResponse.getBody();
        System.out.println("Updated User: " + userUpdated);
        assertEquals(newUser.getEmail(), userUpdated.getEmail());
    }

    @Disabled
    @Test
    void d_delete() {
        String URL = BASE_URL + "/delete/" + user.getEmail();
        System.out.println("URL: " + URL);
        restTemplate.delete(URL);
        System.out.println("Success: Deleted user");
    }

    @Test
    void e_getAll() {
        String URL = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
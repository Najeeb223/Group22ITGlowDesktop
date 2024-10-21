package za.ac.cput.controllerTest;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.factory.ServiceProviderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SPControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ITGlowMobileApp/serviceProvider";

    private static ServiceProvider sp;

    @BeforeAll
    public static void setup() {
        // Generate a valid service code as a long
        long validServiceCode = 123456789L;

        sp = ServiceProviderFactory.buildSP(
                "88372",
                "Likhona",
                "Nxusani",
                "Likhs25@gmail.com",
                "0652347864",
                "0213456723",
                validServiceCode,
                "Barber",
                "Men's Haircuts",
                "Women's Haircuts",
                150.00
        );
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<ServiceProvider> postResponse = restTemplate.postForEntity(url, sp, ServiceProvider.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ServiceProvider savedSP = postResponse.getBody();
        assertEquals(sp.getProviderId(), savedSP.getProviderId());
        System.out.println("Saved data:" + savedSP);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + sp.getProviderId();
        System.out.println("URL: " + url);
        ResponseEntity<ServiceProvider> response = restTemplate.getForEntity(url, ServiceProvider.class);
        assertNotNull(response.getBody());
        assertEquals(sp.getProviderId(), response.getBody().getProviderId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        ServiceProvider newProvider = new ServiceProvider.Builder().copy(sp)
                .setFirstName("Roundy").build();
        ResponseEntity<ServiceProvider> postResponse = restTemplate.postForEntity(url, newProvider, ServiceProvider.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ServiceProvider updatedSP = postResponse.getBody();
        assertEquals(newProvider.getProviderId(), updatedSP.getProviderId());
        System.out.println("Updated data:" + updatedSP);
    }

    @Disabled
    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + sp.getProviderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted Service Provider");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}

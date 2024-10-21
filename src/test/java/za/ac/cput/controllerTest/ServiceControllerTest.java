package za.ac.cput.controllerTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Service;
import za.ac.cput.factory.ServiceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8081/ITGlow/service";
    private static Service service;

    @BeforeAll
    public static void setup() {
        service = ServiceFactory.buildService("Haircuts", "buzzcut", "ponytail", 152.00);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Service> postResponse = restTemplate.postForEntity(url, service, Service.class);
        assertNotNull(postResponse, "Post response should not be null");
        assertNotNull(postResponse.getBody(), "Response body should not be null");

        Service serviceSaved = postResponse.getBody();
        assertNotNull(serviceSaved.getServiceCode(), "Service code should not be null");

        // Output debug information
        System.out.println("Saved data: " + serviceSaved);
        assertNotNull(serviceSaved.getServiceCode(), "Service code should be auto-generated and non-null");
    }

    @Test
    void b_read() {
        ResponseEntity<Service> postResponse = restTemplate.postForEntity(BASE_URL + "/create", service, Service.class);
        Service createdService = postResponse.getBody();
        assertNotNull(createdService, "Created service should not be null");

        String url = BASE_URL + "/read/" + createdService.getServiceCode();
        ResponseEntity<Service> response = restTemplate.getForEntity(url, Service.class);
        assertNotNull(response, "Read response should not be null");
        assertNotNull(response.getBody(), "Response body should not be null");

        Service serviceRead = response.getBody();
        assertNotNull(serviceRead.getServiceCode(), "Service code should not be null");
        assertEquals(createdService.getServiceCode(), serviceRead.getServiceCode(), "Service codes should match");

        // Output debug information
        System.out.println("Read: " + serviceRead);
    }

    @Test
    void c_update() {
        // Ensure the service is created first
        ResponseEntity<Service> postResponse = restTemplate.postForEntity(BASE_URL + "/create", service, Service.class);
        Service createdService = postResponse.getBody();
        assertNotNull(createdService, "Created service should not be null");

        String url = BASE_URL + "/update";
        Service updatedService = new Service.Builder()
                .copy(createdService)
                .setServiceName("Frontal Ponytail")
                .build();
        ResponseEntity<Service> putResponse = restTemplate.postForEntity(url, updatedService, Service.class);
        assertNotNull(putResponse, "Put response should not be null");
        assertNotNull(putResponse.getBody(), "Response body should not be null");

        Service serviceUpdated = putResponse.getBody();
        assertNotNull(serviceUpdated.getServiceCode(), "Service code should not be null");
        assertEquals(updatedService.getServiceCode(), serviceUpdated.getServiceCode(), "Service codes should match");

        // Output debug information
        System.out.println("Updated data: " + serviceUpdated);
    }

    @Disabled
    @Test
    void d_delete() {
        ResponseEntity<Service> postResponse = restTemplate.postForEntity(BASE_URL + "/create", service, Service.class);
        Service createdService = postResponse.getBody();
        assertNotNull(createdService, "Created service should not be null");

        String url = BASE_URL + "/delete/" + createdService.getServiceCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted the service");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}

package za.ac.cput.controllerTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:3306/ITGlowDesktop/client";

    private static Client client;

    @BeforeAll
    public static void setup(){
        client = ClientFactory.buildClient("123456","Liks",
                "Nxusain", "123456@workmail.ac.za", "07234516"
                , "0215734628");
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Client> postResponse = restTemplate.postForEntity(url,client, Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Client savedClient = postResponse.getBody();
        assertEquals(client.getClientId(), savedClient.getClientId());
        System.out.println("Saved data:" + savedClient);
    }

    @Test
    void b_read(){
        String url = BASE_URL + "/read/" + client.getClientId();
        System.out.println("URL: " + url);
        ResponseEntity<Client> response = restTemplate.getForEntity(url, Client.class);
        assertEquals(client.getClientId(), response.getBody().getClientId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Client newClient = new Client.Builder().copy(client)
                .setFirstName("Roundy").build();
        ResponseEntity<Client> postResponse = restTemplate.postForEntity(url,newClient, Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Client updatedClient = postResponse.getBody();
        assertEquals(newClient.getClientId(), updatedClient.getClientId());
        System.out.println("Updated data:" + updatedClient);
    }

    @Test
    void d_delete(){
        String url = BASE_URL + "/delete/" + client.getClientId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted client");
    }

    @Test
    void e_getAll(){
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
package za.ac.cput.controllerTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/ITGlowDesktop/payment";

    private static Payment payment;

    @BeforeAll
    public static void setUp() {
        Client client = new Client.Builder()
                .setClientId("001")
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        payment = PaymentFactory.createPayment("123", "456", "001", 1000.00, "Credit Card", new Date(), client);
    }

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment savedPayment = postResponse.getBody();
        assertEquals(payment.getPaymentID(), savedPayment.getPaymentID());
        System.out.println("Created Payment: " + savedPayment);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + payment.getPaymentID();
        System.out.println("URL: " + url);
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertNotNull(response.getBody());
        System.out.println("Read Payment: " + response.getBody());
        assertEquals(payment.getPaymentID(), response.getBody().getPaymentID());
    }

    @Test
    void c_update() {
        String url = baseURL + "/update";
        Payment newPayment = new Payment.Builder().copy(payment).setAmount(1500.00).build();
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, newPayment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment updatedPayment = postResponse.getBody();
        System.out.println("Updated Payment: " + updatedPayment);
        assertEquals(newPayment.getPaymentID(), updatedPayment.getPaymentID());
    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + payment.getPaymentID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted Payment");
    }

    @Test
    void e_getAll() {
        String url = baseURL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}

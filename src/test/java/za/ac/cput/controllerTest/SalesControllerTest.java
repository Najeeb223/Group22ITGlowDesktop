package za.ac.cput.controllerTest;
/*Sinentlahla Pindani 219081328
        26 May 2024

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;

import za.ac.cput.domain.Sales;

import za.ac.cput.factory.SalesFactory;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalesControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/ITGlow/sales";

    private static Sales sales;

    @BeforeAll
    public static void setUp() {
        sales = SalesFactory.createSales("S222", "E333", "Cornrows");
    }



    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Sales> postResponse = restTemplate.postForEntity(url, sales, Sales.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Sales salesSaved = postResponse.getBody();
        assertEquals(sales.getSalesID(), salesSaved.getSalesID());
        System.out.println("Created Sales: " + salesSaved);


    }



    @Test
    void b_read() {
        String url = baseURL + "/read/" + sales.getSalesID();
        System.out.println("URL: " + url);
        ResponseEntity<Sales> response = restTemplate.getForEntity(url, Sales.class);
        assertNotNull(response.getBody());
        System.out.println("Read Sales: " + response.getBody());
        assertEquals(sales.getSalesID(), response.getBody().getSalesID());



    }

    @Test
    void c_update() {
        String url = baseURL + "/update";
        Sales newSales = new Sales.Builder().copy(sales).setSalesDescription("short nails").build();
        ResponseEntity<Sales> postResponse = restTemplate.postForEntity(url, newSales, Sales.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Sales salesUpdated = postResponse.getBody();
        System.out.println("Updated Sales: " + salesUpdated);
        assertEquals(newSales.getSalesID(), salesUpdated.getSalesID());
    }

    @Disabled
    @Test
    void d_delete() {
        String url = baseURL + "/delete/" + sales.getSalesID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted sales");
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
 */
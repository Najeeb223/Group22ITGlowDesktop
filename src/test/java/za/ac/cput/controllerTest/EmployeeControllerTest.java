package za.ac.cput.controllerTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/ITGlowDesktop/employee";
    private static Employee employee;

    @BeforeAll
    public static void setup() {
        employee = EmployeeFactory.buildEmployee(
                218130260L,
                "joka",
                "zimkhita",
                "zimmy1",
                "hairstylist",
                "627xhq",
                "aphelele@gmail.com"
        );
    }

    @Test
    void a_create() {
        String URL = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(URL, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Employee employeeSaved = postResponse.getBody();
        assertEquals(employee.getIdNumber(), employeeSaved.getIdNumber());
        System.out.println("Created Employee: " + employeeSaved);
    }

    @Test
    void b_read() {
        String URL = BASE_URL + "/read/" + employee.getIdNumber();
        System.out.println("URL: " + URL);
        ResponseEntity<Employee> response = restTemplate.getForEntity(URL, Employee.class);
        assertNotNull(response.getBody());
        System.out.println("Read Employee: " + response.getBody());
        assertEquals(employee.getIdNumber(), response.getBody().getIdNumber());
    }

    @Test
    void c_update() {
        String URL = BASE_URL + "/update";
        Employee newEmployee = new Employee.Builder().copy(employee).setFirstName("Aphelele Joka").build();
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(URL, newEmployee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Employee employeeUpdated = postResponse.getBody();
        System.out.println("Updated Employee: " + employeeUpdated);
        assertEquals(newEmployee.getIdNumber(), employeeUpdated.getIdNumber());  // Changed to getIdNumber
    }

    @Disabled
    @Test
    void d_delete() {
        String URL = BASE_URL + "/delete/" + employee.getIdNumber();
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

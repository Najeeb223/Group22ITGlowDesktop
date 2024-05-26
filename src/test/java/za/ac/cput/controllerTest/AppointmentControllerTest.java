
package za.ac.cput.controllerTest;
/*Sinentlahla Pindani 219081328
        26 May 2024
        */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Appointment;


import za.ac.cput.factory.AppointmentFactory;



import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/ITGlowDesktop/appointment";
    private static Appointment appointment;

    @BeforeAll
    public static void setup(){
        appointment = AppointmentFactory.createAppointment("A123", "C234", "E345",new Date(),new Time(12,20,0)) ;
    }

    @Test
    void a_create() {
        String url = baseURL + "/create" ;
        ResponseEntity<Appointment> postResponse = restTemplate. postForEntity(url, appointment, Appointment.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Appointment appointmentSaved = postResponse.getBody();
        assertEquals(appointment.getAppointmentID(), appointmentSaved.getAppointmentID());
        System.out.println("Saved data:" + appointmentSaved);

    }

    @Test
    void b_read() {
        String  url = baseURL + "/read/" + appointment.getAppointmentID();
        System.out.println("URL:" + url);
        ResponseEntity<Appointment> response = restTemplate.getForEntity(url,Appointment.class);
        assertNotNull(response.getBody());
        System.out.println("Read appointments:"+ response.getBody());
        assertEquals(appointment.getAppointmentID(), response.getBody().getAppointmentID());
    }

    @Test
    void c_update() {
        String url = baseURL + "/update";
        Appointment newAppointment = new Appointment.Builder().copy(appointment).setClientId("C222").build();
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(url, newAppointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Appointment appointmentUpdated = postResponse.getBody();
        assertEquals(newAppointment.getAppointmentID(), appointmentUpdated.getAppointmentID());
        System.out.println("Updated data:"+ appointmentUpdated);

    }

    @Test
    @Disabled
    void e_delete() {
        String  url = baseURL + "/delete" + appointment.getAppointmentID();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted appointment");
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll" ;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}
package za.ac.cput.controllerTest;
/*OkuhleVellem*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Schedule;
import za.ac.cput.factory.ScheduleFactory;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ITGlowDesktop/schedule";
    private static Schedule schedule;

    @BeforeAll
    public static void setup() {
        schedule = ScheduleFactory.buildSchedule("12345", "54321", Date.valueOf("2024-05-26"), Time.valueOf("09:00:00"), Time.valueOf("17:00:00"));
    }

    @Test
    void a_create() {
        String URL = BASE_URL + "/create";
        ResponseEntity<Schedule> postResponse = restTemplate.postForEntity(URL, schedule, Schedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Schedule scheduleSaved = postResponse.getBody();
        assertEquals(schedule.getScheduleId(), scheduleSaved.getScheduleId());
        System.out.println("Created Schedule: " + scheduleSaved);
    }

    @Test
    void b_read() {
        String URL = BASE_URL + "/read/" + schedule.getScheduleId();
        System.out.println("URL: " + URL);
        ResponseEntity<Schedule> response = restTemplate.getForEntity(URL, Schedule.class);
        assertNotNull(response.getBody());
        System.out.println("Read Schedule: " + response.getBody());
        assertEquals(schedule.getScheduleId(), response.getBody().getScheduleId());
    }

    @Test
    void c_update() {
        String URL = BASE_URL + "/update";
        Schedule newSchedule = new Schedule.Builder().copy(schedule).setStartTime(Time.valueOf("08:00:00")).build();
        ResponseEntity<Schedule> postResponse = restTemplate.postForEntity(URL, newSchedule, Schedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Schedule scheduleUpdated = postResponse.getBody();
        System.out.println("Updated Schedule: " + scheduleUpdated);
        assertEquals(newSchedule.getScheduleId(), scheduleUpdated.getScheduleId());
    }

    @Disabled
    @Test
    void d_delete() {
        String URL = BASE_URL + "/delete/" + schedule.getScheduleId();
        System.out.println("URL: " + URL);
        restTemplate.delete(URL);
        System.out.println("Success: Deleted schedule");
    }

    @Test
    void e_getAll() {
        String URL = BASE_URL + "/getall";
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}

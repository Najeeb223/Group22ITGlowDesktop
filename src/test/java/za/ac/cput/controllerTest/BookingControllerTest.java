package za.ac.cput.controllerTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.service.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookingService bookingService;

    private Booking booking;

    @BeforeEach
    void setUp() {
        // Create a sample ServiceProvider for the booking
        ServiceProvider serviceProvider = new ServiceProvider.Builder()
                .setProviderId("testProvider")
                .setLastName("Doe")
                .setContact(new Contact.Builder()
                        .setEmail("john@example.com")
                        .setWorkTelephone("123456789")
                        .setMobileNumber("0612907731").build()) // Example contact
                .setService(new Service.Builder()
                        .setServiceCode(123456L) // Set service code
                        .setServiceName("Women's Haircut")
                        .setWomensServiceDescription("A stylish women's haircut.")
                        .setPrice(200.0)
                        .build()) // Create the Service object with women's service details
                .build();
        Service service = new Service.Builder()
                .setServiceCode(Long.valueOf("HAIRWASH1"))
                .setServiceName("Washing hair")
                .setWomensServiceDescription("Wash hair and dry")
                .setPrice(150)
                .build();
        // Create a sample User
        User user = new User.Builder()
                .setEmail("user@example.com") // Replace with the correct user email
                .build();

        // Initialize the booking with the ServiceProvider and User object
        booking = new Booking();
        booking.setUser(user); // Set the user object instead of userID
        booking.setService(service); // Ensure this matches the Service object's serviceCode
        booking.setServiceProvider(serviceProvider); // Use the ServiceProvider object
        booking.setDate(LocalDate.now());
        booking.setTime(LocalTime.now());

        // Setting up authentication
        restTemplate = restTemplate.withBasicAuth("kuhle", "k@123"); // Replace with valid credentials
    }

    @Test
    void testCreateBooking() {
        ResponseEntity<Booking> response = restTemplate.postForEntity("/api/bookings", booking, Booking.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Booking createdBooking = response.getBody();
        assertNotNull(createdBooking);
        assertEquals(booking.getUser().getEmail(), createdBooking.getUser().getEmail()); // Compare user email
        assertEquals(booking.getService(), createdBooking.getService());
        assertEquals(booking.getServiceProvider().getProviderId(), createdBooking.getServiceProvider().getProviderId()); // Check service provider
    }

    @Test
    void testGetBookingById() {
        Booking savedBooking = bookingService.createBooking(booking);
        String url = UriComponentsBuilder.fromUriString("/api/bookings/{id}")
                .buildAndExpand(savedBooking.getBookingID())
                .toUriString();
        ResponseEntity<Booking> response = restTemplate.getForEntity(url, Booking.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Booking retrievedBooking = response.getBody();
        assertNotNull(retrievedBooking);
        assertEquals(savedBooking.getUser().getEmail(), retrievedBooking.getUser().getEmail()); // Compare user email
        assertEquals(savedBooking.getService(), retrievedBooking.getService());
        assertEquals(savedBooking.getServiceProvider().getProviderId(), retrievedBooking.getServiceProvider().getProviderId()); // Check service provider
    }
}
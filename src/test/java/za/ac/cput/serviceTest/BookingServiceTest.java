package za.ac.cput.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.BookingRepository;
import za.ac.cput.service.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    private Booking booking;

    @BeforeEach
    void setUp() {
        long serviceCode = 123456L;

        // Create the Service object
        Service service = new Service.Builder()
                .setServiceCode(serviceCode)
                .setServiceName("Sample Service")
                .setWomensServiceDescription("Women's Service Description") // Women's service description
                .setPrice(100.00)
                .build();

        // Create the ServiceProvider object
        ServiceProvider serviceProvider = new ServiceProvider.Builder()
                .setProviderId("provider789")
                .setLastName("Smith")
                .setContact(new Contact.Builder()
                        .setEmail("jane@example.com")
                        .setMobileNumber("987654321")
                        .setWorkTelephone("123567789")
                        .build()) // Example contact
                .setService(service) // Associate the service with the provider
                .build();

        // Create a sample User
        User user = new User.Builder()
                .setEmail("user@example.com") // Use email instead of userID
                .build();

        // Create the booking using the ServiceProvider and User object
        booking = new Booking();
        booking.setUser(user); // Set user object
        booking.setService(service);
        booking.setServiceProvider(serviceProvider); // Use the ServiceProvider object
        booking.setDate(LocalDate.now());
        booking.setTime(LocalTime.now());
    }

    @Test
    void testBookingCreation() {
        assertNotNull(booking);
        Booking savedBooking = bookingService.createBooking(booking);
        assertNotNull(savedBooking);
        System.out.println("Created booking: " + savedBooking);
    }

    @Test
    public void testGetBookingById() {
        Booking savedBooking = bookingService.createBooking(booking);
        Booking retrievedBooking = bookingService.getBookingById(savedBooking.getBookingID()).orElse(null);
        assertNotNull(retrievedBooking);
        assertEquals(savedBooking.getBookingID(), retrievedBooking.getBookingID());
    }

    @Test
    public void testUpdateBooking() {
        Booking savedBooking = bookingService.createBooking(booking);
        savedBooking.getUser().setEmail("updatedUser@example.com"); // Update the user email
        Booking updatedBooking = bookingService.updateBooking(savedBooking.getBookingID(), savedBooking);
        assertNotNull(updatedBooking);
        assertEquals("updatedUser@example.com", updatedBooking.getUser().getEmail()); // Check updated email
    }

    @Test
    public void testDeleteBooking() {
        Booking savedBooking = bookingService.createBooking(booking);
        bookingService.deleteBooking(savedBooking.getBookingID());
        assertFalse(bookingService.getBookingById(savedBooking.getBookingID()).isPresent());
    }

    @Test
    public void testGetAllBookings() {
        bookingService.createBooking(booking);
        assertFalse(bookingService.getAllBookings().isEmpty());
    }
}
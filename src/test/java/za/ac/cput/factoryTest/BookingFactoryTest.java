package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.BookingFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import za.ac.cput.domain.*;

public class BookingFactoryTest {

    @Test
    public void testCreateBooking() {
        // Create a sample ServiceProvider for the booking
        ServiceProvider serviceProvider = new ServiceProvider.Builder()
                .setProviderId("provider789")
                .setFirstName("John")
                .setLastName("Doe")
                .setContact(new Contact.Builder()
                        .setEmail("john@example.com")
                        .setWorkTelephone("123456789")
                        .setMobileNumber("0612906991")
                        .build()) // Example contact
                .setService(new Service.Builder()
                        .setServiceCode(123456L) // Set service code
                        .setServiceName("Women's Haircut")
                        .setWomensServiceDescription("A stylish women's haircut.")
                        .setPrice(200.0)
                        .build()) // Create the Service object with women's service details
                .build();

        long serviceCode = 123456L;

        // Create a sample User object using the email as the identifier
        User user = new User.Builder()
                .setEmail("user123@example.com")
                // .setFirstName("Jane")
                // .setLastName("Doe")
                .setPassword("password123")
                .build();

        // Create a booking using the User and ServiceProvider objects
        Booking booking = BookingFactory.createBooking(
                user, // Pass the User object instead of userId
                serviceCode,
                serviceProvider, // Pass the ServiceProvider object
                LocalDate.now(),
                LocalTime.now()
        );

        assertNotNull(booking);
        assertEquals(user.getEmail(), booking.getUser().getEmail()); // Verify email is used correctly
    }
}

package za.ac.cput.service;

import jakarta.persistence.EntityNotFoundException;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.BookingStatus;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ServiceProvider;
import za.ac.cput.repository.BookingRepository;
import za.ac.cput.repository.ClientRepository;
import za.ac.cput.repository.ServiceProviderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public Booking createBooking(Booking booking) {
        // Ensure that the ServiceProvider is saved first
        ServiceProvider serviceProvider = booking.getServiceProvider();
        if (serviceProvider != null && serviceProviderRepository.findById(serviceProvider.getProviderId()).isEmpty()) {
            serviceProviderRepository.save(serviceProvider); // Save ServiceProvider if not already persisted
        }

        // Now save the Booking
        return bookingRepository.save(booking);
    }    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, @NotNull Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.setUser(bookingDetails.getUser());
        booking.setService(bookingDetails.getService());
        booking.setServiceProvider(bookingDetails.getServiceProvider());
        booking.setDate(bookingDetails.getDate());
        booking.setTime(bookingDetails.getTime());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getPendingBookings() {
        return bookingRepository.findAllByStatus(BookingStatus.PENDING);
    }

    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
        booking.setStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }
}

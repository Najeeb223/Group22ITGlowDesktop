package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
//@CrossOrigin(value = "http://localhost/3004")
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired

    private BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(newBooking);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());


    }

    @GetMapping("getall")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
        return ResponseEntity.ok(updatedBooking);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        System.out.println("Deleted Successfully");
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/pending")
    public ResponseEntity<List<Booking>> getPendingBookings() {
        List<Booking> pendingBookings = bookingService.getPendingBookings();
        return ResponseEntity.ok(pendingBookings);
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<Booking> confirmBooking(@PathVariable Long id) {
        Booking confirmedBooking = bookingService.confirmBooking(id);
        return ResponseEntity.ok(confirmedBooking);
    }
}

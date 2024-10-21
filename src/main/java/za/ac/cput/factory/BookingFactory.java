package za.ac.cput.factory;


import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;


public class BookingFactory {
    public static Booking createBooking(User user, Service service, ServiceProvider serviceProvider, LocalDate date, LocalTime time) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setService(service);
        booking.setServiceProvider(serviceProvider);
        booking.setDate(date);
        booking.setTime(time);
        return booking;
    }

    public static Booking createBooking(User user, long serviceCode, ServiceProvider serviceProvider, LocalDate now, LocalTime now1) {
        return null;
    }
}

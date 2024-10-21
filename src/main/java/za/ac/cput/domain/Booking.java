package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email") // Linking to the email field in the User class
    private User user;


    @ManyToOne
    @JoinColumn(name = "serviceCode", referencedColumnName = "serviceCode")
    private Service service;

    //@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "providerId", referencedColumnName = "providerId") // Linking to ServiceProvider's providerId
    private ServiceProvider serviceProvider;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;

    private LocalDate date;
    private LocalTime time;

    public Booking() {
    }

    public Booking(Long bookingID, User user, Service service, ServiceProvider serviceProvider, LocalDate date, LocalTime time) {
        this.bookingID = bookingID;
        this.user = user;
        this.service = service;
        this.serviceProvider = serviceProvider;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", user=" + user.getEmail() + // Accessing email from the User object
                ", service=" + service +
                ", serviceProvider=" + serviceProvider.getFirstName() + " " + serviceProvider.getLastName() +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}

package za.ac.cput.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;

    @Test
    void testCreatePayment() {

        Payment payment = new Payment.Builder()
                .setPaymentID("1")
                .setBookingID("B001")
                .setUserID("U001")
                .setAmount(100.0)
                .setPaymentMethod("Credit Card")
                .setDatePaid(new Date())
                .setClient(null)
                .build();


        Payment savedPayment = paymentService.createPayment(payment);

        assertNotNull(savedPayment.getPaymentID());

        assertEquals(payment.getBookingID(), savedPayment.getBookingID());
        assertEquals(payment.getUserID(), savedPayment.getUserID());
        assertEquals(payment.getAmount(), savedPayment.getAmount());
        assertEquals(payment.getPaymentMethod(), savedPayment.getPaymentMethod());
        assertEquals(payment.getDatePaid(), savedPayment.getDatePaid());
        assertEquals(payment.getClient(), savedPayment.getClient());
    }

    @Test
    void testGetPaymentById() {

        Payment payment = new Payment.Builder()
                .setPaymentID("1")
                .setBookingID("B001")
                .setUserID("U001")
                .setAmount(100.0)
                .setPaymentMethod("Credit Card")
                .setDatePaid(new Date())
                .setClient(null)
                .build();

        Payment savedPayment = paymentService.createPayment(payment);

        Payment retrievedPayment = paymentService.getPaymentById(savedPayment.getPaymentID());

        assertEquals(savedPayment, retrievedPayment);
    }

    @Test
    void testGetAllPayments() {

        Payment payment1 = new Payment.Builder()
                .setPaymentID("1")
                .setBookingID("B001")
                .setUserID("U001")
                .setAmount(100.0)
                .setPaymentMethod("Credit Card")
                .setDatePaid(new Date())
                .setClient(null)
                .build();

        Payment payment2 = new Payment.Builder()
                .setPaymentID("2")
                .setBookingID("B002")
                .setUserID("U002")
                .setAmount(200.0)
                .setPaymentMethod("PayPal")
                .setDatePaid(new Date())
                .setClient(null)
                .build();


        paymentService.createPayment(payment1);
        paymentService.createPayment(payment2);


        List<Payment> payments = paymentService.getAllPayments();

        assertEquals(2, payments.size());
    }

    @Test
    void testDeletePayment() {

        Payment payment = new Payment.Builder()
                .setPaymentID("1")
                .setBookingID("B001")
                .setUserID("U001")
                .setAmount(100.0)
                .setPaymentMethod("Credit Card")
                .setDatePaid(new Date())
                .setClient(null)
                .build();


        Payment savedPayment = paymentService.createPayment(payment);


        paymentService.deletePayment(savedPayment.getPaymentID());


        Payment retrievedPayment = paymentService.getPaymentById(savedPayment.getPaymentID());


        assertNull(retrievedPayment);
    }
}
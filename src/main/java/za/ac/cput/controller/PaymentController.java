package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@PathVariable String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public void delete(@PathVariable String paymentId) {
        paymentService.deletePayment(paymentId);
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }
}
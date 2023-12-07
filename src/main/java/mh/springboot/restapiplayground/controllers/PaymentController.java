package mh.springboot.restapiplayground.controllers;

import mh.springboot.restapiplayground.model.PaymentDetails;
import mh.springboot.restapiplayground.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        PaymentDetails paymentDetails = paymentService.proceed();
        return ResponseEntity.status(ACCEPTED).body(paymentDetails);
    }
}

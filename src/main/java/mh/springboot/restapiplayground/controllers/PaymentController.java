package mh.springboot.restapiplayground.controllers;

import mh.springboot.restapiplayground.model.ErrorDetails;
import mh.springboot.restapiplayground.model.PaymentDetails;
import mh.springboot.restapiplayground.model.exceptions.NotEnoughMoneyException;
import mh.springboot.restapiplayground.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.proceed();
            return ResponseEntity.status(ACCEPTED).body(paymentDetails);
        } catch (NotEnoughMoneyException exception) {
            return ResponseEntity.status(BAD_REQUEST).body(
                    new ErrorDetails("Not enough money on the account. Declined by payment system."));
        }
    }
}

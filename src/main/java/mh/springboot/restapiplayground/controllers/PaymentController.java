package mh.springboot.restapiplayground.controllers;

import mh.springboot.restapiplayground.model.PaymentDetails;
import mh.springboot.restapiplayground.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class PaymentController {

    private final PaymentService paymentService;
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {
        logger.info("Received the following payment request:" + paymentDetails);
        PaymentDetails paymentResult = paymentService.proceed(paymentDetails);
        logger.info("The following payment has been processed: " + paymentResult);
        return ResponseEntity.status(ACCEPTED).body(paymentResult);
    }
}

package mh.springboot.restapiplayground.services;

import mh.springboot.restapiplayground.model.PaymentDetails;
import mh.springboot.restapiplayground.model.exceptions.AmountPaymentException;
import mh.springboot.restapiplayground.model.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;

@Service
public class PaymentService {

    public PaymentDetails proceed(PaymentDetails paymentDetails) {
        if (paymentDetails.amount() <= 0) {
            throw new AmountPaymentException("Payment should be grater then 0.00");
        }
        if (paymentDetails.amount() > 1000){
            throw new NotEnoughMoneyException("Not enough money on the account! :(");
        }
        return new PaymentDetails(paymentDetails.amount(), now());
    }
}

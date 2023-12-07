package mh.springboot.restapiplayground.services;

import mh.springboot.restapiplayground.model.PaymentDetails;
import mh.springboot.restapiplayground.model.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails proceed() {
        // throwing exception on purpose
        throw new NotEnoughMoneyException("Not enough money on the account! :(");
    }
}

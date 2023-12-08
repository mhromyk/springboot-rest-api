package mh.springboot.restapiplayground.model.exceptions;

public class AmountPaymentException extends RuntimeException {
    public AmountPaymentException(String message) {
        super(message);
    }
}

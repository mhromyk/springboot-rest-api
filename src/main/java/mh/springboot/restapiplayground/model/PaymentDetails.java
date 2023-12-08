package mh.springboot.restapiplayground.model;


import java.time.LocalDateTime;

public record PaymentDetails(double amount, LocalDateTime paymentDate) {
}

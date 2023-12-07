package mh.springboot.restapiplayground.controllers.exceptions;

import mh.springboot.restapiplayground.model.ErrorDetails;
import mh.springboot.restapiplayground.model.exceptions.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(value = NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoney(NotEnoughMoneyException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(new ErrorDetails(exception.getMessage()));
    }
}

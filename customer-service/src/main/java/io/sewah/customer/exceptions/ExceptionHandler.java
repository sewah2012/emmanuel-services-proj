package io.sewah.customer.exceptions;

import io.sewah.customer.exceptions.errors.AlreadyExistException;
import io.sewah.customer.exceptions.errors.FraudsterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> alreadyExistException(AlreadyExistException ex){
        log.error(String.format("Exception occurred: [ %s ] resulted in: [ %s ]", ex.getLocalizedMessage(), ex.getClass().getName()));
        return ResponseEntity
                .status(HttpStatus.ALREADY_REPORTED)
                .body(ErrorMessage.builder()
                        .message(ex.getLocalizedMessage())
                        .statusCode(HttpStatus.ALREADY_REPORTED.value())
                        .build()
                );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FraudsterException.class)
    public ResponseEntity<?> fraudsterExceptionHandler(FraudsterException ex){
        log.error(String.format("Exception occurred: [ %s ] resulted in: [ %s ]", ex.getLocalizedMessage(), ex.getClass().getName()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.builder()
                        .message(ex.getLocalizedMessage())
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build()
                );
    }

}

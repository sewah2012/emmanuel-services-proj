package io.sewah.customer.exceptions;

import io.sewah.customer.exceptions.errors.AlreadyExistException;
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

}

package ru.gb.runov.spring.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.gb.runov.spring.exceptions.MуError;
import ru.gb.runov.spring.exceptions.ResourceNotFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
      //  log.error(e.getMessage());
        MуError err = new MуError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

/*    @ExceptionHandler
    public ResponseEntity<?> handleNoAuthException(NoAuthException e) {
        log.error(e.getMessage());
        MarketError err = new MarketError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
    } */
}

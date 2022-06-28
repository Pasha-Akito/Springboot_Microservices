package guru.springframework.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errorsList = new ArrayList<>(e.getConstraintViolations().size());
        //Iterating over constraint violations and adding to list
        e.getConstraintViolations().forEach(constraintViolation -> errorsList.add(constraintViolation.toString()));
        //Returning 400 Bad Request with list of constraint violations
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }

}

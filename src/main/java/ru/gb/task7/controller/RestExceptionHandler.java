package ru.gb.task7.controller;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.text.ParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleSqlException(SQLException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Incorrect product data. " + ex.getMessage());
    }

    @ExceptionHandler({ParseException.class, InvalidDefinitionException.class})
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleParseException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Incorrect data. " + ex.getMessage());
    }


}

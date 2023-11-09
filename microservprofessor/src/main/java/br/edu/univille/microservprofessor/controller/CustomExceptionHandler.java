package br.edu.univille.microservprofessor.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.univille.microservprofessor.exceptions.ProfessorAlreadyExistsException;
import br.edu.univille.microservprofessor.exceptions.ProfessorNotFoundException;


@ControllerAdvice
public class CustomExceptionHandler{
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorMessage, errorMessage.getStatus());
    }

    @ExceptionHandler(ProfessorAlreadyExistsException.class)
    private ResponseEntity<Object> handleProfessorAlreadyExistsException(ProfessorAlreadyExistsException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorMessage errorMessage = new ErrorMessage(status, exception.getMessage());
        return ResponseEntity.status(status)
                .body(errorMessage);
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    private ResponseEntity<Object> handleProfessorNotFoundException(ProfessorNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessage errorMessage = new ErrorMessage(status, exception.getMessage());
        return ResponseEntity.status(status)
                .body(errorMessage);
    }
}

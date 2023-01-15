package org.cherif.mediatheque.exceptions.handler;


import lombok.Builder;
import org.cherif.mediatheque.exceptions.EntityAlreadyExistsException;
import org.cherif.mediatheque.exceptions.EntityNotFoundException;
import org.cherif.mediatheque.shared.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
//@ControllerAdvice

public class AppExceptionHandler { // gestionnaire d'exceptions

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex){
        // chaque exception = message + date de erreur
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timstamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

    }

    //MethodArgumentNotValidException

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> HandleMethodArgumentNotValid(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(eroor->  //pour chaque fild, on retien l'exception
                errors.put(eroor.getField(),eroor.getDefaultMessage()));  // elle l'ajoute à la map errors selon le champs
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
        //return on la recupere dans la reponse

    }
    //

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex){
        // chaque exception = message + date de erreur
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .timstamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);

    }

}

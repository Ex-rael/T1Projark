package com.projark.trab.Excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AeroviaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AeroviaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String aeroviaNotFoundHandler(AeroviaNotFoundException ex) {
        return ex.getMessage();
    }
}

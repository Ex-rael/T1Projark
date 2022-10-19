package com.projark.trab.Excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AeronaveNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AeronaveNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AeronaveNotFoundHandler(AeronaveNotFoundException ex) {
        return ex.getMessage();
    }

}

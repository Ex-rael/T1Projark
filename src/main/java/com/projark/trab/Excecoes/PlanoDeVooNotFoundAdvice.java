package com.projark.trab.Excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PlanoDeVooNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PlanoDeVooNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String PlanoDeVooNotFoundHandler(PlanoDeVooNotFoundException ex) {
        return ex.getMessage();
    }

}

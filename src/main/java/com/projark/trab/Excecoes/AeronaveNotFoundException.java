package com.projark.trab.Excecoes;

public class AeronaveNotFoundException extends RuntimeException {

    public AeronaveNotFoundException(Long id) {
        super("Aeronave " + id + " não encontrada.");
    }

}

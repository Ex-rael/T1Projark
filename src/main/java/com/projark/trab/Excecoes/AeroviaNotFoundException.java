package com.projark.trab.Excecoes;

public class AeroviaNotFoundException extends RuntimeException {

    public AeroviaNotFoundException(Long id) {
        super("Aerovia " + id + " não encontrada.");
    }

}

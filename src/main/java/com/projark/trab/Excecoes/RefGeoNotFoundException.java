package com.projark.trab.Excecoes;

public class RefGeoNotFoundException extends RuntimeException {

    public RefGeoNotFoundException(Long id) {
        super("Referência geográfica " + id + " não encontrada.");
    }

}

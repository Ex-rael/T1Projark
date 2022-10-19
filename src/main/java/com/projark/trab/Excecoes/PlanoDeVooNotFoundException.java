package com.projark.trab.Excecoes;

public class PlanoDeVooNotFoundException extends RuntimeException {

    public PlanoDeVooNotFoundException(Long id) {
        super("Plano de voo " + id + " não encontrado.");
    }

}

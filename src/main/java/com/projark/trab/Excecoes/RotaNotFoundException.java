package com.projark.trab.Excecoes;

public class RotaNotFoundException extends RuntimeException {

    public RotaNotFoundException(Long id) {
        super("Rota " + id + " não encontrada.");
    }

}

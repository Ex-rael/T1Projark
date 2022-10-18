package com.projark.trab.Dominio;

import java.util.Random;

public class AeronavePassageiros extends Aeronave {

    public String prefixo(String prefixo) {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "PA- " + numPrefix;
        return prefCompleto;
    }

    private int velocidadeCruzeiro(int velCruzeiro) {
        velCruzeiro = 850;
        return velCruzeiro;
    }

    private int autonomia(int autonomia) {
        autonomia = 15;
        return autonomia;
    }
}

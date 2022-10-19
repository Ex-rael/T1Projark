package com.projark.trab.Dominio;

import java.util.Random;

public class AeronavePassageiros extends Aeronave {

    public String prefixo() {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "PA- " + numPrefix;
        return prefCompleto;
    }

    public int velocidadeCruzeiro() {
        int velCruzeiro = 850;
        return velCruzeiro;
    }

    public int autonomia() {
        int autonomia = 15;
        return autonomia;
    }
}

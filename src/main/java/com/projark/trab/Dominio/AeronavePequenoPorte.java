package com.projark.trab.Dominio;

import java.util.Random;

public class AeronavePequenoPorte extends Aeronave {

    public String prefixo(String prefixo) {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "PP- " + numPrefix;
        return prefCompleto;
    }

    private int velocidadeCruzeiro(int velCruzeiro) {
        velCruzeiro = 450;
        return velCruzeiro;
    }

    private int autonomia(int autonomia) {
        autonomia = 10;
        return autonomia;
    }
}

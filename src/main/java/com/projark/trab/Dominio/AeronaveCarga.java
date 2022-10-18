package com.projark.trab.Dominio;

import java.util.Random;

public class AeronaveCarga extends Aeronave {

    public String prefixo(String prefixo) {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "CA- " + numPrefix;
        return prefCompleto;
    }

    private int velocidadeCruzeiro(int velCruzeiro) {
        velCruzeiro = 900;
        return velCruzeiro;
    }

    private int autonomia(int autonomia) {
        autonomia = 20;
        return autonomia;
    }
}

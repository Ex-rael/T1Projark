package com.projark.trab.Dominio.Entidades;

import java.util.Random;

public class AeronaveCarga extends Aeronave {

    public String prefixo() {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "CA- " + numPrefix;
        return prefCompleto;
    }

    public int velocidadeCruzeiro() {
        int velCruzeiro = 900;
        return velCruzeiro;
    }

    public int autonomia() {
        int autonomia = 20;
        return autonomia;
    }
}

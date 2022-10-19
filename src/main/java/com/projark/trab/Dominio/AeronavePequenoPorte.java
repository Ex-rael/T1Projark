package com.projark.trab.Dominio;

import java.util.Random;

public class AeronavePequenoPorte extends Aeronave {

    public String prefixo() {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "PP- " + numPrefix;
        return prefCompleto;
    }

    public int velocidadeCruzeiro() {
        int velCruzeiro = 450;
        return velCruzeiro;
    }

    public int autonomia() {
        int autonomia = 10;
        return autonomia;
    }
}

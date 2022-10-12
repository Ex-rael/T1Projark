package com.projark.trab.Dominio;

public class Aerovia {
    private String nome;
    private RefGeo origem;
    private RefGeo destino;
    private double distancia;

    public Aerovia(String nome, RefGeo origem, RefGeo destino, double distancia) {
        if(nome.matches([AV]-))//regex <==============
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RefGeo getOrigem() {
        return origem;
    }

    public void setOrigem(RefGeo origem) {
        this.origem = origem;
    }

    public RefGeo getDestino() {
        return destino;
    }

    public void setDestino(RefGeo destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    private boolean isDistanciaValid(double distancia){
        boolean isDistanciaValid = false;
        if(distancia == 1000){
            isDistanciaValid = true;
        } 
        return isDistanciaValid;     
    }
}

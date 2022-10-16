package com.projark.trab.Dominio;

public class Rota {

    private int idRota;
    private String nome;
    private RefGeo origem;
    private RefGeo destino;

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public Rota(String nome) {
        this.nome = nome;
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

    public RefGeo getDestino() {
        return destino;
    }

}
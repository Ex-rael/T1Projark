package com.projark.trab.Aplicacao.DTOs;

public class DadosRefGeoDTO {
    private String refPartida;
    private String refChegada;

    public DadosRefGeoDTO(String refPartida, String refChegada) {
        this.refPartida = refPartida;
        this.refChegada = refChegada;
    }

    public String getRefPartida() {
        return refPartida;
    }

    public void setRefPartida(String refPartida) {
        this.refPartida = refPartida;
    }

    public String getRefChegada() {
        return refChegada;
    }

    public void setRefChegada(String refChegada) {
        this.refChegada = refChegada;
    }
}

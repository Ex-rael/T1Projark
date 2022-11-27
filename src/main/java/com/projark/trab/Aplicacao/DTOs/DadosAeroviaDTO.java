package com.projark.trab.Aplicacao.DTOs;

public class DadosAeroviaDTO {

    private long idAerovia;
    private String horarioPartida;
    private float velocidadeCruzeiro;

    public DadosAeroviaDTO(long idAerovia, String horarioPartida, float velocidadeCruzeiro) {
        this.idAerovia = idAerovia;
        this.horarioPartida = horarioPartida;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public long getIdAerovia() {
        return idAerovia;
    }

    public void setIdAerovia(long idAerovia) {
        this.idAerovia = idAerovia;
    }

    public String getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public float getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public void setVelocidadeCruzeiro(float velocidadeCruzeiro) {
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

}

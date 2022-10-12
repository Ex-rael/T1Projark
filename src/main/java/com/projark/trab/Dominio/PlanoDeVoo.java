package com.projark.trab.Dominio;

import java.util.Date;

public class PlanoDeVoo {
    private int idVoo;
    private Date data;
    private double altitude;
    private Rota rota;
    private double velCruzeiro;

    public PlanoDeVoo(int idVoo, Date data, double altitude, Rota rota, double velCruzeiro) {
        this.idVoo = idVoo;
        this.data = data;
        this.altitude = altitude;
        this.rota = rota;
        this.velCruzeiro = velCruzeiro;
    }

    public int getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public double getVelCruzeiro() {
        return velCruzeiro;
    }

    public void setVelCruzeiro(double velCruzeiro) {
        this.velCruzeiro = velCruzeiro;
    }

}

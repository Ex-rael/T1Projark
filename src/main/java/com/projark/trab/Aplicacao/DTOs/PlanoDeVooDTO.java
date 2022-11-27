package com.projark.trab.Aplicacao.DTOs;

import java.time.LocalDateTime;
import java.util.Objects;

import com.projark.trab.Dominio.Entidades.Rota;

public class PlanoDeVooDTO {
    private LocalDateTime data;
    private double altitude;
    private Rota rota;
    private double velCruzeiro;
    
    public PlanoDeVooDTO(LocalDateTime data, double altitude, Rota rota, double velCruzeiro) {
        this.data = data;
        this.altitude = altitude;
        this.rota = rota;
        this.velCruzeiro = velCruzeiro;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setVelCruzeiro(double velCruzeiro) {
        this.velCruzeiro = velCruzeiro;
    }

    public double getAltitude() {
        return altitude;
    }

    public Rota getRota() {
        return rota;
    }

    public double getVelCruzeiro() {
        return velCruzeiro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, altitude, rota, velCruzeiro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PlanoDeVooDTO))
            return false;
        PlanoDeVooDTO other = (PlanoDeVooDTO) obj;
        return Objects.equals(data, other.data)
                && Double.doubleToLongBits(altitude) == Double.doubleToLongBits(other.altitude)
                && Objects.equals(rota, other.rota)
                && Double.doubleToLongBits(velCruzeiro) == Double.doubleToLongBits(other.velCruzeiro);
    }
}

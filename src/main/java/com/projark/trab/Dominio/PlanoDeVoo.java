package com.projark.trab.Dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanoDeVoo {
    private @Id @GeneratedValue Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date data;
    private double altitude;
    private Rota rota;
    private double velCruzeiro;

    public PlanoDeVoo(Date data, double altitude, Rota rota, double velCruzeiro) {
        this.data = data;
        this.altitude = altitude;
        this.rota = rota;
        this.velCruzeiro = velCruzeiro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        long temp;
        temp = Double.doubleToLongBits(altitude);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((rota == null) ? 0 : rota.hashCode());
        temp = Double.doubleToLongBits(velCruzeiro);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlanoDeVoo other = (PlanoDeVoo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (Double.doubleToLongBits(altitude) != Double.doubleToLongBits(other.altitude))
            return false;
        if (rota == null) {
            if (other.rota != null)
                return false;
        } else if (!rota.equals(other.rota))
            return false;
        if (Double.doubleToLongBits(velCruzeiro) != Double.doubleToLongBits(other.velCruzeiro))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PlanoDeVoo [id=" + id + ", data=" + data + ", altitude=" + altitude + ", rota=" + rota
                + ", velCruzeiro=" + velCruzeiro + "]";
    }

}

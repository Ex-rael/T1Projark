package com.projark.trab.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAeronave;

    private String prefixo() {
        return null;
    }

    private int velocidadeCruzeiro() {
        return 0;
    }

    private int autonomia() {
        return 0;
    }

    public boolean isAltitudeValid(int altitude) {
        if ((altitude >= 25000) && (altitude <= 35000) && (altitude % 1000 == 0)) {
            return true;
        } else
            return false;
    }

    public int getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }
}

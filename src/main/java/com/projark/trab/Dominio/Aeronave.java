package com.projark.trab.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeronave {

    private @Id @GeneratedValue Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)

    public String prefixo(String prefixo) {
        return prefixo;
    }

    private int velocidadeCruzeiro(int velCruzeiro) {
        return velCruzeiro;
    }

    private int autonomia(int autonomia) {
        return autonomia;
    }

    public boolean isAltitudeValid(int altitude) {
        if ((altitude >= 25000) && (altitude <= 35000) && (altitude % 1000 == 0)) {
            return true;
        } else
            return false;
    }

    public Long getId() {
        return id;
    }

    public void setIdAeronave(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Aeronave other = (Aeronave) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

package com.projark.trab.Dominio.Entidades;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aeronaves")
public class Aeronave {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;

    public String prefixo() {
        Random numPrefix = new Random(999);
        StringBuilder sb = new StringBuilder();
        sb.append(numPrefix);
        String prefCompleto = "AA- " + numPrefix;
        return prefCompleto;
    }

    public int velocidadeCruzeiro() {
        int velCruzeiro = 500;
        return velCruzeiro;
    }

    public int autonomia() {
        int autonomia = 10;
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

    public void setId(Long id) {
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

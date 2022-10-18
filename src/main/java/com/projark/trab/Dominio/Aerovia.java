package com.projark.trab.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aerovia {
    private @Id @GeneratedValue Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private RefGeo origem;
    private RefGeo destino;
    private double distancia;

    public Aerovia(String nome, RefGeo origem, RefGeo destino, double distancia)
            throws IllegalArgumentException {
        // tratamento de input
        if (nome.matches("[AV][0-9]{1,}[:][A][0-9]{1,}[->][A][0-9]{1,}")) {
            if (distancia > 0) {
                if (origem != null) {
                    if (destino != null) {
                        this.origem = origem;
                        this.destino = destino;
                        this.nome = nome;
                        this.distancia = distancia;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        long temp;
        temp = Double.doubleToLongBits(distancia);
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
        Aerovia other = (Aerovia) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (Double.doubleToLongBits(distancia) != Double.doubleToLongBits(other.distancia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aerovia [id=" + id + ", nome=" + nome + ", origem=" + origem + ", destino=" + destino + ", distancia="
                + distancia + "]";
    }

}

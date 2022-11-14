package com.projark.trab.Dominio.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "ocupacoes_aerovias_altitudes")
public class OcupacaoAeroviasAltitude {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;

    private int altitude;
    private boolean ocupada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ocupacao_id", nullable = false)
    private OcupacaoAerovia ocupacao;

    public OcupacaoAeroviasAltitude() {

    }

    public OcupacaoAeroviasAltitude(int altitude, boolean ocupada, OcupacaoAerovia ocupacao) {
        this.altitude = altitude;
        this.ocupada = ocupada;
        this.ocupacao = ocupacao;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "OcupacaoAeroviasAltitude [id=" + id + ", altitude=" + altitude + ", ocupada=" + ocupada + ", ocupacao="
                + ocupacao + "]";
    }

}

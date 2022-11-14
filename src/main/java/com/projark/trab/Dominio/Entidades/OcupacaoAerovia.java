package com.projark.trab.Dominio.Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ocupacao_aerovias")
public class OcupacaoAerovia {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;

    private LocalDateTime horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aerovia_id", nullable = false)
    private Aerovia aerovia;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ocupacao")
    private List<OcupacaoAeroviasAltitude> altitudes = new ArrayList<>();

    public OcupacaoAerovia(Long id, LocalDateTime horario, Aerovia aerovia, List<OcupacaoAeroviasAltitude> altitudes) {
        this.id = id;
        this.horario = horario;
        this.aerovia = aerovia;
        this.altitudes = altitudes;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public List<OcupacaoAeroviasAltitude> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(List<OcupacaoAeroviasAltitude> altitudes) {
        this.altitudes = altitudes;
    }

    @Override
    public String toString() {
        return "OcupacaoAerovia [id=" + id + ", horario=" + horario + ", aerovia=" + aerovia + ", altitudes="
                + altitudes + "]";
    }

}

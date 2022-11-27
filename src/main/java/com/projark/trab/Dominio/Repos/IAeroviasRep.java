package com.projark.trab.Dominio.Repos;

import com.projark.trab.Dominio.Entidades.Aerovia;
import com.projark.trab.Dominio.Entidades.OcupacaoAerovia;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IAeroviasRep {
    Optional<Aerovia> consultarPorId(long id);

    Optional<OcupacaoAerovia> consultarOcupacaoPorDataEHorario(long id, LocalDateTime horario);

    boolean salvarOcupacao(OcupacaoAerovia ocupacaoAerovia);
}

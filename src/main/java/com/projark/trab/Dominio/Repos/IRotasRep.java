package com.projark.trab.Dominio.Repos;

import java.util.List;
import java.util.Optional;

import com.projark.trab.Dominio.Entidades.Rota;

public interface IRotasRep {
    Optional<Rota> consultarPorId(long idRota);

    List<Rota> consultarTodasAsRotas();
}

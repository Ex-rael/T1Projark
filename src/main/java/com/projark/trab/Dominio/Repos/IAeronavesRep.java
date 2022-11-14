package com.projark.trab.Dominio.Repos;

import java.util.Optional;

import com.projark.trab.Dominio.Entidades.Aeronave;

public interface IAeronavesRep {

    Optional<Aeronave> buscarPorId(long id);

}

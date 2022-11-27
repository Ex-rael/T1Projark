package com.projark.trab.Dominio.Repos;

import java.util.List;
import java.util.Optional;

import com.projark.trab.Dominio.Entidades.PlanoDeVoo;

public interface IPlanosRep {
    List<PlanoDeVoo> buscarTodos();

    Optional<PlanoDeVoo> buscarPlanoDeVooPorId(long id);

    PlanoDeVoo salvarPlanoDeVoo(PlanoDeVoo planoDeVoo);

}

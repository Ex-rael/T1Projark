package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projark.trab.Dominio.Aeronave;

//@Repository
public interface RepositorioAeronaves extends JpaRepository<Aeronave, Long> {

}

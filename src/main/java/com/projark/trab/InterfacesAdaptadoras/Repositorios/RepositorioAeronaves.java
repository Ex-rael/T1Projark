package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.Aeronave;

public interface RepositorioAeronaves extends JpaRepository<Aeronave, Long> {

}

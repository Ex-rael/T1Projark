package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.Aeronave;
import com.projark.trab.Dominio.IAeronavesRep;

public interface RepositorioAeronaves extends JpaRepository<Aeronave,Integer>{

    

}

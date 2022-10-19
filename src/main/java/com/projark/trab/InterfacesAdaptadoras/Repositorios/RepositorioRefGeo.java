package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projark.trab.Dominio.RefGeo;

@Repository
public interface RepositorioRefGeo extends JpaRepository<RefGeo, Long> {

}

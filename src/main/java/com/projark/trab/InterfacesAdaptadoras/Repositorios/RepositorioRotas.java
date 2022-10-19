package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projark.trab.Dominio.Rota;

@Repository
public interface RepositorioRotas extends JpaRepository<Rota, Long> {

}

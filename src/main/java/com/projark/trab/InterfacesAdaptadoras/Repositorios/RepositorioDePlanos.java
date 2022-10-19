package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projark.trab.Dominio.PlanoDeVoo;

@Repository
public interface RepositorioDePlanos extends JpaRepository<PlanoDeVoo, Long> {

}

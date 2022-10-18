package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.PlanoDeVoo;

public interface RepositorioDePlanos extends JpaRepository<PlanoDeVoo, Long> {

}

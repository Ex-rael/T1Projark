package com.projark.trab.Adaptadores.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.Entidades.PlanoDeVoo;

public interface IRepPlanosCRUD extends JpaRepository<PlanoDeVoo, Long> {

}

package com.projark.trab.Adaptadores.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.Entidades.Aeronave;

public interface IRepAeronavesCRUD extends JpaRepository<Aeronave, Long> {

}

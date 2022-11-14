package com.projark.trab.Adaptadores.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projark.trab.Dominio.Entidades.Aerovia;

public interface IRepAeroviasCRUD extends JpaRepository<Aerovia, Long> {

}

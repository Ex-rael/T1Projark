package com.projark.trab.Dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private RefGeo origem;
    private RefGeo destino;

    public Rota(int id, String nome, RefGeo origem, RefGeo destino) {
        this.id = id;
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
    }

    public int getIdRota() {
        return id;
    }

    public void setIdRota(int id) {
        this.id = id;
    }

    public Rota(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RefGeo getOrigem() {
        return origem;
    }

    public RefGeo getDestino() {
        return destino;
    }

}

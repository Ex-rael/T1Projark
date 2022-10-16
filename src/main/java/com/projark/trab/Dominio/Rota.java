package com.projark.trab.Dominio;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class Rota {

    private int idRota;
    private String nome;
    private RefGeo origem;
    private RefGeo destino;

    public Rota(int idRota, String nome, RefGeo origem, RefGeo destino) {
        this.idRota = idRota;
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
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

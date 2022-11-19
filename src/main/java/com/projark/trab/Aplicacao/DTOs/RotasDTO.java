package com.projark.trab.Aplicacao.DTOs;

import java.util.ArrayList;
import java.util.List;
import com.projark.trab.Dominio.Entidades.Aerovia;

// teste
public class RotasDTO {
    private long id;
    private String nome;
    private List<Aerovia> aerovias = new ArrayList<>();

    public RotasDTO(long id, String nome, ArrayList<Aerovia> aerovias) {
        this.id = id;
        this.nome = nome;
        this.aerovias = aerovias;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Aerovia> getAerovias() {
        return aerovias;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAerovias(ArrayList<Aerovia> aerovias) {
        this.aerovias = aerovias;
    }
}

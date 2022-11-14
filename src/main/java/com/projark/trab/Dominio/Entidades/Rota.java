package com.projark.trab.Dominio.Entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "rotas")
public class Rota {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;

    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rotas_aerovias", joinColumns = @JoinColumn(name = "rota_id"), inverseJoinColumns = @JoinColumn(name = "aerovia_id"))
    private List<Aerovia> aerovias = new ArrayList<>();

    public Rota(Long id, String nome, List<Aerovia> aerovias) {
        this.id = id;
        this.nome = nome;
        this.aerovias = aerovias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((aerovias == null) ? 0 : aerovias.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rota other = (Rota) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (aerovias == null) {
            if (other.aerovias != null)
                return false;
        } else if (!aerovias.equals(other.aerovias))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rota [id=" + id + ", nome=" + nome + ", aerovias=" + aerovias + "]";
    }

    public List<Aerovia> getAerovias() {
        return aerovias;
    }

    public void setAerovias(List<Aerovia> aerovias) {
        this.aerovias = aerovias;
    }

}

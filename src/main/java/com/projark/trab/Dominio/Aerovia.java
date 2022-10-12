package com.projark.trab.Dominio;

public class Aerovia {
    private int idAerovia;
    private String nome;
    private RefGeo origem;
    private RefGeo destino;
    private double distancia;

    public Aerovia(String nome, RefGeo origem, RefGeo destino, double distancia, int idAerovia)
            throws IllegalArgumentException {
        // tratamento de input
        if (nome.matches("[AV][0-9]{1,}[:][A][0-9]{1,}[->][A][0-9]{1,}")) {
            if (distancia > 0) {
                if (origem != null) {
                    if (destino != null) {
                        this.idAerovia = idAerovia;
                        this.origem = origem;
                        this.destino = destino;
                        this.nome = nome;
                        this.distancia = distancia;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getIdAerovia() {
        return idAerovia;
    }

    public void setIdAerovia(int idAerovia) {
        this.idAerovia = idAerovia;
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

    public void setOrigem(RefGeo origem) {
        this.origem = origem;
    }

    public RefGeo getDestino() {
        return destino;
    }

    public void setDestino(RefGeo destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}

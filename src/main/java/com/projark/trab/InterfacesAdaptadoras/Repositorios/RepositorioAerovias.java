package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import com.projark.trab.Dominio.Aerovia;
import com.projark.trab.Dominio.IAeroviasRep;

public class RepositorioAerovias {

    private IAeroviasRep iar;

    public RepositorioAerovias(IAeroviasRep iar) {
        this.iar = iar;
    }

}

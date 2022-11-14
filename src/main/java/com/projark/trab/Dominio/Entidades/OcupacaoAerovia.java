package com.projark.trab.Dominio.Entidades;

import java.sql.Date;

public class OcupacaoAerovia {
    private Date data;
    private TabelaOcupacao altitudes[];

    public OcupacaoAerovia(Date data, TabelaOcupacao[] altitudes) {
        this.data = data;
        this.altitudes = altitudes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TabelaOcupacao[] getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(TabelaOcupacao[] altitudes) {
        this.altitudes = altitudes;
    }

}

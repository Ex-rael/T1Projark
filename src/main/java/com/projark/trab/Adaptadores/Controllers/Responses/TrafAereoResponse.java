package com.projark.trab.Adaptadores.Controllers.Responses;

public class TrafAereoResponse {
    private String mensagem;
    private Object dados;

    public TrafAereoResponse(String mensagem, Object dados) {
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public String getmensagem() {
        return mensagem;
    }

    public void setmensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Object getdados() {
        return dados;
    }

    public void setdados(Object dados) {
        this.dados = dados;
    }
}

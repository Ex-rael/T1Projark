package com.projark.trab.Adaptadores.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projark.trab.Adaptadores.Controllers.Responses.TrafAereoResponse;
import com.projark.trab.Adaptadores.Repositorios.Slots;
import com.projark.trab.Aplicacao.CasosDeUso.*;
import com.projark.trab.Aplicacao.DTOs.DadosAeroviaDTO;

@RestController
@RequestMapping("/trafego-aereo")
public class TrafAereoController {

    private ConsultarSlotsLivres consultarSlotsLivres;
    private ConsultarRotas consultarRotas;
    private VerificarPlanoDeVoo verificarPlanoDeVoo;
    private AutorizarPlanoDeVoo autorizarPlanoDeVoo;
    private CancelarPlanoDeVoo cancelarPlanoDeVoo;
    private CriarRelatorio criarRelatorio;

    public TrafAereoController(ConsultarSlotsLivres consultarSlotsLivres, ConsultarRotas consultarRotas,
            VerificarPlanoDeVoo verificarPlanoDeVoo, AutorizarPlanoDeVoo autorizarPlanoDeVoo,
            CancelarPlanoDeVoo cancelarPlanoDeVoo, CriarRelatorio criarRelatorio) {
        this.consultarSlotsLivres = consultarSlotsLivres;
        this.consultarRotas = consultarRotas;
        this.verificarPlanoDeVoo = verificarPlanoDeVoo;
        this.autorizarPlanoDeVoo = autorizarPlanoDeVoo;
        this.cancelarPlanoDeVoo = cancelarPlanoDeVoo;
        this.criarRelatorio = criarRelatorio;
    }

}

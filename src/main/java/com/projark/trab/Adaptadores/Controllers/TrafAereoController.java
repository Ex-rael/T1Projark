package com.projark.trab.Adaptadores.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projark.trab.Adaptadores.Controllers.Responses.TrafAereoResponse;
import com.projark.trab.Adaptadores.Repositorios.Slots;
import com.projark.trab.Aplicacao.CasosDeUso.*;
import com.projark.trab.Aplicacao.DTOs.DadosAeroviaDTO;
import com.projark.trab.Aplicacao.DTOs.DadosRefGeoDTO;
import com.projark.trab.Aplicacao.DTOs.PlanoDeVooDTO;
import com.projark.trab.Aplicacao.DTOs.RelatorioAltitudeDTO;
import com.projark.trab.Dominio.Entidades.PlanoDeVoo;
import com.projark.trab.Dominio.Entidades.Rota;

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

    @GetMapping("/slots")
    public ResponseEntity<TrafAereoResponse> consultarSlotsDisponiveis(@RequestBody DadosAeroviaDTO dadosAerovia) {
        try {
            Slots slotsDisponiveis = consultarSlotsLivres.consultarSlotsLivres(dadosAerovia);
            TrafAereoResponse respostaSucesso = new TrafAereoResponse("Sucesso ao consultar slots disponiveis",
                    slotsDisponiveis);
            return ResponseEntity.of(Optional.of(respostaSucesso));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    @GetMapping("/rotas")
    public ResponseEntity<TrafAereoResponse> consultarRotasPossiveis(@RequestBody DadosRefGeoDTO dadosRefGeo) {
        try {
            List<Rota> rotasEncontradas = consultarRotas.consultarRotasEntreDoisDestinos(dadosRefGeo);
            TrafAereoResponse respostaSucesso = new TrafAereoResponse(
                    "Sucesso ao consultar rotas entre os dois pontos", rotasEncontradas);
            return ResponseEntity.of(Optional.of(respostaSucesso));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    @GetMapping("/planos/verificar")
    public ResponseEntity<TrafAereoResponse> verificarPlanoDeVoo(@RequestBody PlanoDeVooDTO planoDeVoo) {
        try {
            String mensagemConsulta = "O plano de voo nao pode ser liberado nas aerovias listadas";
            List<String> aeroviasComErro = verificarPlanoDeVoo.verificarPlanoDeVoo(planoDeVoo);
            if (aeroviasComErro.size() == 0)
                mensagemConsulta = "O plano de voo informado pode ser liberado";

            return ResponseEntity.of(Optional.of(new TrafAereoResponse(mensagemConsulta, aeroviasComErro)));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    @PostMapping("/planos/liberar")
    public ResponseEntity<TrafAereoResponse> autorizarPlanoDeVoo(@RequestBody PlanoDeVooDTO planoDeVoo) {
        try {
            PlanoDeVoo planoDeVooLiberado = autorizarPlanoDeVoo.autorizarPlanoDeVoo(planoDeVoo);
            TrafAereoResponse respostaSucesso = new TrafAereoResponse("O plano de voo foi liberado com sucesso",
                    planoDeVooLiberado);
            return ResponseEntity.of(Optional.of(respostaSucesso));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    @PostMapping("/planos/cancelar/{id}")
    public ResponseEntity<TrafAereoResponse> cancelarPlanoDeVoo(@PathVariable Long id) {
        try {
            PlanoDeVoo planoDeVooCancelado = cancelarPlanoDeVoo.cancelarPlanoDeVoo(id);
            TrafAereoResponse respostaSucesso = new TrafAereoResponse("O plano de voo foi cancelado com sucesso",
                    planoDeVooCancelado);
            return ResponseEntity.of(Optional.of(respostaSucesso));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    @GetMapping("/estatisticas/{id}/data/{data}")
    public ResponseEntity<TrafAereoResponse> gerarRelatorio(@PathVariable Long id, @PathVariable String data) {
        try {
            List<RelatorioAltitudeDTO> relatorios = criarRelatorio.gerarRelatorioAerovia(id, data);
            TrafAereoResponse respostaSucesso = new TrafAereoResponse("Relatório de ocupação gerado com sucesso",
                    relatorios);
            return ResponseEntity.of(Optional.of(respostaSucesso));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(construirRespostaErro(ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(construirRespostaErro(ex.getMessage()));
        }
    }

    private TrafAereoResponse construirRespostaErro(String mensagem) {
        return new TrafAereoResponse(mensagem, null);
    }

}

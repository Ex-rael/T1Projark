package com.projark.trab.Aplicacao.CasosDeUso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;

import com.projark.trab.Adaptadores.Repositorios.Slots;
import com.projark.trab.Aplicacao.DTOs.DadosAeroviaDTO;
import com.projark.trab.Dominio.Servicos.ServicoAerovias;

public class ConsultarSlotsLivres {

    private DateTimeFormatter dateTimeFormatter;
    private ServicoAerovias servicoAerovias;

    @Autowired
    public ConsultarSlotsLivres(DateTimeFormatter dateTimeFormatter, ServicoAerovias servicoAerovias) {
        this.dateTimeFormatter = dateTimeFormatter;
        this.servicoAerovias = servicoAerovias;
    }

    public Slots consultarSlotsLivres(DadosAeroviaDTO dadosAerovia) {
        try {
            if (dadosAerovia == null || dadosAerovia.getHorarioPartida() == null) {
                throw new IllegalArgumentException("Os dados da aerovia estao vazios ou incompletos");
            }
            if (dadosAerovia.getVelocidadeCruzeiro() <= 0) {
                throw new IllegalArgumentException("A velocidade de cruzeiro deve ser maior que zero");
            }
            LocalDateTime dataFormatada = LocalDateTime.parse(dadosAerovia.getHorarioPartida(), dateTimeFormatter);
            return servicoAerovias.consultarSlotsDisponiveisPorIdAerovia(
                    dadosAerovia.getIdAerovia(), dataFormatada, dadosAerovia.getVelocidadeCruzeiro());
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Horario da partida possui formato invalido");
        }
    }

}

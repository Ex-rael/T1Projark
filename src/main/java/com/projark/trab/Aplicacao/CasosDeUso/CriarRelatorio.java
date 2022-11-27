package com.projark.trab.Aplicacao.CasosDeUso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projark.trab.Aplicacao.DTOs.RelatorioAltitudeDTO;
import com.projark.trab.Dominio.Servicos.ServicoRelatorio;

@Component
public class CriarRelatorio {
    private DateTimeFormatter dateFormatter;
    private ServicoRelatorio servicoRelatorio;

    @Autowired
    public CriarRelatorio(DateTimeFormatter dateFormatter, ServicoRelatorio servicoRelatorio) {
        this.dateFormatter = dateFormatter;
        this.servicoRelatorio = servicoRelatorio;
    }

    public List<RelatorioAltitudeDTO> CriarRelatorioAerovia(long idAerovia, String data) {
        try {
            LocalDate dataFormatada = LocalDate.parse(data, dateFormatter);
            return servicoRelatorio.gerarRelatorioAerovia(idAerovia, dataFormatada);

        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Data inserida possui formato invalido");

        }
    }

}

package com.projark.trab.Dominio.Servicos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projark.trab.Aplicacao.DTOs.RelatorioAltitudeDTO;
import com.projark.trab.Dominio.Entidades.OcupacaoAerovia;
import com.projark.trab.Dominio.Entidades.OcupacaoAeroviasAltitude;
import com.projark.trab.Dominio.Repos.IAeroviasRep;

@Service
public class ServicoRelatorio {
    public IAeroviasRep aeroviasRepository;

    @Autowired
    public ServicoRelatorio(IAeroviasRep aeroviasRepository) {
        this.aeroviasRepository = aeroviasRepository;
    }

    public List<RelatorioAltitudeDTO> gerarRelatorioAerovia(long idAerovia, LocalDate data) {
        Map<Integer, Integer> contagemPorAltitude = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            LocalDateTime horario = LocalDateTime.of(data, LocalTime.MIDNIGHT);
            horario = horario.plusHours(i);

            Optional<OcupacaoAerovia> ocupacao = aeroviasRepository.consultarOcupacaoPorDataEHorario(idAerovia,
                    horario);
            if (ocupacao.isPresent()) {
                for (OcupacaoAeroviasAltitude ocupacaoAeroviaAltitude : ocupacao.get().getAltitudes()) {
                    if (ocupacaoAeroviaAltitude.isOcupada()) {
                        contagemPorAltitude.put(ocupacaoAeroviaAltitude.getAltitude(),
                                contagemPorAltitude.getOrDefault(ocupacaoAeroviaAltitude.getAltitude(), 0) + 1);
                    }
                }
            }
        }

        return contagemPorAltitude.entrySet().stream()
                .map(entry -> new RelatorioAltitudeDTO(entry.getKey(), (entry.getValue() * 100.0) / 24))
                .collect(Collectors.toList());
    }

}

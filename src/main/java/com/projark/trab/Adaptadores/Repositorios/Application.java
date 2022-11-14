// T1 de Projeto e Arquitetura de Software - Arthur Zanella Lovato, Felipe Fonseca Fagundes, Israel Graziola Garcia, Luiz Felipe Porto Lara de Oliveira
// github.com/Ex-rael/T1Projark
package com.projark.trab.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.projark.trab.Adaptadores.Repositorios.IRepAeronavesCRUD;
import com.projark.trab.Adaptadores.Repositorios.IRepAeroviasCRUD;
import com.projark.trab.Adaptadores.Repositorios.IRepPlanosCRUD;
import com.projark.trab.Adaptadores.Repositorios.IRepRefGeoCRUD;
import com.projark.trab.Adaptadores.Repositorios.IRepRotasCRUD;
import com.projark.trab.Dominio.Entidades.AeronaveCarga;
import com.projark.trab.Dominio.Entidades.AeronavePassageiros;
import com.projark.trab.Dominio.Entidades.AeronavePequenoPorte;
import com.projark.trab.Dominio.Entidades.Aerovia;
import com.projark.trab.Dominio.Entidades.PlanoDeVoo;
import com.projark.trab.Dominio.Entidades.RefGeo;
import com.projark.trab.Dominio.Entidades.Rota;

@SpringBootApplication
@EnableJpaRepositories

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // população do banco
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    CommandLineRunner iniciarBanco(IRepRefGeoCRUD repositorioRefGeo,
            IRepAeronavesCRUD repositorioAeronaves, IRepAeroviasCRUD repositorioAerovias,
            IRepPlanosCRUD repositorioDePlanos, IRepRotasCRUD repositorioRotas) {

        return args -> {
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A1", 0, 0)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A2", 200, 100)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A3", 450, 335)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A4", 650, 500)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A5", 800, 1000)));

            log.info("Carregando " + repositorioAeronaves.save(new AeronaveCarga()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronaveCarga()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronavePassageiros()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronavePequenoPorte()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronavePequenoPorte()));

            // espaço para aerovias, rotas e planos de voos(descobrir como ligar refGeos
            // adicionadas no banco)

        };
    }

}
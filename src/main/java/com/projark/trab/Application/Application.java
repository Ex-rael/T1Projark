package com.projark.trab.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projark.trab.Dominio.AeronaveCarga;
import com.projark.trab.Dominio.AeronavePassageiros;
import com.projark.trab.Dominio.AeronavePequenoPorte;
import com.projark.trab.Dominio.RefGeo;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioAeronaves;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioAerovias;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioDePlanos;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioRefGeo;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioRotas;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // população do banco
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    CommandLineRunner iniciarBanco(RepositorioRefGeo repositorioRefGeo,
            RepositorioAeronaves repositorioAeronaves, RepositorioAerovias repositorioAerovias,
            RepositorioDePlanos repositorioDePlanos, RepositorioRotas repositorioRotas) {

        return args -> {
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A1", 0, 0)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A2", 200, 100)));
            log.info("Carregando " + repositorioRefGeo.save(new RefGeo("A3", 450, 335)));

            log.info("Carregando " + repositorioAeronaves.save(new AeronaveCarga()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronavePassageiros()));
            log.info("Carregando " + repositorioAeronaves.save(new AeronavePequenoPorte()));

        };
    }

}
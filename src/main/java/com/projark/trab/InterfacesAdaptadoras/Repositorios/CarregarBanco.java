package com.projark.trab.InterfacesAdaptadoras.Repositorios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.projark.trab.Controllers.RefGeoController;
import com.projark.trab.Dominio.AeronaveCarga;
import com.projark.trab.Dominio.AeronavePassageiros;
import com.projark.trab.Dominio.AeronavePequenoPorte;
import com.projark.trab.Dominio.Aerovia;
import com.projark.trab.Dominio.RefGeo;

@Configuration
public class CarregarBanco {

    private static final Logger log = LoggerFactory.getLogger(CarregarBanco.class);

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

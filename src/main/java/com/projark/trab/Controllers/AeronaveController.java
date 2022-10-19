package com.projark.trab.Controllers;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projark.trab.Dominio.Aeronave;
import com.projark.trab.Dominio.AeronaveCarga;
import com.projark.trab.Dominio.AeronavePassageiros;
import com.projark.trab.Dominio.AeronavePequenoPorte;
import com.projark.trab.Excecoes.AeronaveNotFoundException;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioAeronaves;

@RestController
public class AeronaveController {

    @Bean(name = "entityManagerFactoryAeronave")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final RepositorioAeronaves repositorioAeronaves;

    AeronaveController(RepositorioAeronaves repositorioAeronaves) {
        this.repositorioAeronaves = repositorioAeronaves;
    }

    @GetMapping("/aeronave")
    List<Aeronave> all() {
        return repositorioAeronaves.findAll();
    }

    @PostMapping("/aeronave")
    AeronaveCarga novaAeronaveCarga(@RequestBody AeronaveCarga novaAeronaveCarga) {
        return repositorioAeronaves.save(novaAeronaveCarga);
    }

    @PostMapping("/aeronave")
    AeronavePassageiros novaAeronavePassageiros(@RequestBody AeronavePassageiros novaAeronavePassageiros) {
        return repositorioAeronaves.save(novaAeronavePassageiros);
    }

    @PostMapping("/aeronave")
    AeronavePequenoPorte novaAeronavePequenoPorte(@RequestBody AeronavePequenoPorte novaAeronavePequenoPorte) {
        return repositorioAeronaves.save(novaAeronavePequenoPorte);
    }

    @GetMapping("/aeronave/{id}")
    Aeronave one(@PathVariable Long id) {
        return repositorioAeronaves.findById(id)
                .orElseThrow(() -> new AeronaveNotFoundException(id));
    }

    @PutMapping("/aeronave/{id}")
    Aeronave substituirAeronaveCarga(@RequestBody AeronaveCarga novaAeronaveCarga, @PathVariable Long id) {
        return repositorioAeronaves.findById(id).map(AeronaveCarga -> {
            AeronaveCarga.prefixo();
            AeronaveCarga.velocidadeCruzeiro();
            AeronaveCarga.autonomia();
            return repositorioAeronaves.save(AeronaveCarga);
        })
                .orElseGet(() -> {
                    novaAeronaveCarga.setId(id);
                    return repositorioAeronaves.save(novaAeronaveCarga);
                });

    }

    @PutMapping("/aeronave/{id}")
    Aeronave substituirAeronavePassageiros(@RequestBody AeronavePassageiros novaAeronavePassageiros,
            @PathVariable Long id) {
        return repositorioAeronaves.findById(id).map(AeronavePassageiros -> {
            AeronavePassageiros.prefixo();
            AeronavePassageiros.velocidadeCruzeiro();
            AeronavePassageiros.autonomia();
            return repositorioAeronaves.save(AeronavePassageiros);
        })
                .orElseGet(() -> {
                    novaAeronavePassageiros.setId(id);
                    return repositorioAeronaves.save(novaAeronavePassageiros);
                });

    }

    @PutMapping("/aeronave/{id}")
    Aeronave substituirAeronaveDeCarga(@RequestBody AeronavePequenoPorte novaAeronavePequenoPorte,
            @PathVariable Long id) {
        return repositorioAeronaves.findById(id).map(AeronavePequenoPorte -> {
            AeronavePequenoPorte.prefixo();
            AeronavePequenoPorte.velocidadeCruzeiro();
            AeronavePequenoPorte.autonomia();
            return repositorioAeronaves.save(AeronavePequenoPorte);
        })
                .orElseGet(() -> {
                    novaAeronavePequenoPorte.setId(id);
                    return repositorioAeronaves.save(novaAeronavePequenoPorte);
                });

    }

    @DeleteMapping("/aeronave/{id}")
    void deleteaeronave(@PathVariable Long id) {
        repositorioAeronaves.deleteById(id);
    }

}

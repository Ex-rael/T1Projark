package com.projark.trab.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projark.trab.Dominio.Aerovia;
import com.projark.trab.Excecoes.AeroviaNotFoundException;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioAerovias;

@RestController
public class AeroviaController {

    @Bean(name = "entityManagerFactoryAerovia")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final RepositorioAerovias repositorioAerovias;

    AeroviaController(RepositorioAerovias repositorioAerovias) {
        this.repositorioAerovias = repositorioAerovias;
    }

    @GetMapping("/aerovia")
    List<Aerovia> all() {
        return repositorioAerovias.findAll();
    }

    @PostMapping("/aerovia")
    Aerovia novoAerovia(@RequestBody Aerovia newAerovia) {
        return repositorioAerovias.save(newAerovia);
    }

    @GetMapping("/aerovia/{id}")
    Aerovia one(@PathVariable Long id) {
        return repositorioAerovias.findById(id)
                .orElseThrow(() -> new AeroviaNotFoundException(id));
    }

    @PutMapping("/aerovia/{id}")
    Aerovia substituirAerovia(@RequestBody Aerovia novoAerovia, @PathVariable Long id) {
        return repositorioAerovias.findById(id).map(Aerovia -> {
            Aerovia.setNome(novoAerovia.getNome());
            Aerovia.setNome(novoAerovia.getNome());
            Aerovia.setOrigem(novoAerovia.getOrigem());
            Aerovia.setDestino(novoAerovia.getDestino());
            Aerovia.setDistancia(novoAerovia.getDistancia());
            return repositorioAerovias.save(Aerovia);
        })
                .orElseGet(() -> {
                    novoAerovia.setId(id);
                    return repositorioAerovias.save(novoAerovia);
                });

    }

    @DeleteMapping("/aerovia/{id}")
    void deleteAerovia(@PathVariable Long id) {
        repositorioAerovias.deleteById(id);
    }

}

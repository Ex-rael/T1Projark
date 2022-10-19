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

import com.projark.trab.Dominio.PlanoDeVoo;
import com.projark.trab.Excecoes.PlanoDeVooNotFoundException;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioDePlanos;

@RestController
public class PlanoDeVooController {

    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final RepositorioDePlanos RepositorioDePlanos;

    PlanoDeVooController(RepositorioDePlanos RepositorioDePlanos) {
        this.RepositorioDePlanos = RepositorioDePlanos;
    }

    @GetMapping("/planoDeVoo")
    List<PlanoDeVoo> all() {
        return RepositorioDePlanos.findAll();
    }

    @PostMapping("/planoDeVoo")
    PlanoDeVoo novoPlanoDeVoo(@RequestBody PlanoDeVoo newPlanoDeVoo) {
        return RepositorioDePlanos.save(newPlanoDeVoo);
    }

    @GetMapping("/planoDeVoo/{id}")
    PlanoDeVoo one(@PathVariable Long id) {
        return RepositorioDePlanos.findById(id)
                .orElseThrow(() -> new PlanoDeVooNotFoundException(id));
    }

    @PutMapping("/planoDeVoo/{id}")
    PlanoDeVoo substituirPlanoDeVoo(@RequestBody PlanoDeVoo novoPlanoDeVoo, @PathVariable Long id) {
        return RepositorioDePlanos.findById(id).map(PlanoDeVoo -> {
            PlanoDeVoo.setData(novoPlanoDeVoo.getData());
            PlanoDeVoo.setAltitude(novoPlanoDeVoo.getAltitude());
            PlanoDeVoo.setRota(novoPlanoDeVoo.getRota());
            PlanoDeVoo.setVelCruzeiro(novoPlanoDeVoo.getVelCruzeiro());
            return RepositorioDePlanos.save(PlanoDeVoo);
        })
                .orElseGet(() -> {
                    novoPlanoDeVoo.setId(id);
                    return RepositorioDePlanos.save(novoPlanoDeVoo);
                });

    }

    @DeleteMapping("/planoDeVoo/{id}")
    void deletePlanoDeVoo(@PathVariable Long id) {
        RepositorioDePlanos.deleteById(id);
    }

}

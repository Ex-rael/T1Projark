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

import com.projark.trab.Dominio.Rota;
import com.projark.trab.Excecoes.RotaNotFoundException;
import com.projark.trab.InterfacesAdaptadoras.Repositorios.RepositorioRotas;

@RestController
public class RotaController {

    @Bean(name = "entityManagerFactoryRota")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final RepositorioRotas repositorioRotas;

    RotaController(RepositorioRotas repositorioRotas) {
        this.repositorioRotas = repositorioRotas;
    }

    @GetMapping("/rota")
    List<Rota> all() {
        return repositorioRotas.findAll();
    }

    @PostMapping("/rota")
    Rota novoRota(@RequestBody Rota newRota) {
        return repositorioRotas.save(newRota);
    }

    @GetMapping("/rota/{id}")
    Rota one(@PathVariable Long id) {
        return repositorioRotas.findById(id)
                .orElseThrow(() -> new RotaNotFoundException(id));
    }

    @PutMapping("/rota/{id}")
    Rota substituirRota(@RequestBody Rota novoRota, @PathVariable Long id) {
        return repositorioRotas.findById(id).map(Rota -> {
            Rota.setNome(novoRota.getNome());
            Rota.setOrigem(novoRota.getOrigem());
            Rota.setDestino(novoRota.getDestino());
            return repositorioRotas.save(Rota);
        })
                .orElseGet(() -> {
                    novoRota.setId(id);
                    return repositorioRotas.save(novoRota);
                });

    }

    @DeleteMapping("/rota/{id}")
    void deleteRota(@PathVariable Long id) {
        repositorioRotas.deleteById(id);
    }

}

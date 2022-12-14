package com.projark.trab.Adaptadores.Repositorios;

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

import com.projark.trab.Dominio.Entidades.Rota;
import com.projark.trab.Excecoes.RotaNotFoundException;

@RestController
public class RepositorioRota {

    @Bean(name = "entityManagerFactoryRota")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final IRepRotasCRUD repositorioRotas;

    RepositorioRota(IRepRotasCRUD repositorioRotas) {
        this.repositorioRotas = repositorioRotas;
    }

    @GetMapping("/rota")
    List<Rota> all() {
        return repositorioRotas.findAll();
    }

    @PostMapping("/rota")
    Rota novaRota(@RequestBody Rota newRota) {
        return repositorioRotas.save(newRota);
    }

    @GetMapping("/rota/{id}")
    Rota one(@PathVariable Long id) {
        return repositorioRotas.findById(id)
                .orElseThrow(() -> new RotaNotFoundException(id));
    }

    @PutMapping("/rota/{id}")
    Rota substituirRota(@RequestBody Rota novaRota, @PathVariable Long id) {
        return repositorioRotas.findById(id).map(Rota -> {
            Rota.setNome(novaRota.getNome());
            Rota.setAerovias(novaRota.getAerovias());
            return repositorioRotas.save(Rota);
        })
                .orElseGet(() -> {
                    novaRota.setId(id);
                    return repositorioRotas.save(novaRota);
                });

    }

    @DeleteMapping("/rota/{id}")
    void deleteRota(@PathVariable Long id) {
        repositorioRotas.deleteById(id);
    }

}

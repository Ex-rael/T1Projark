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

import com.projark.trab.Dominio.Entidades.RefGeo;
import com.projark.trab.Excecoes.RefGeoNotFoundException;

@RestController
public class RepositorioRefGeo {

    @Bean(name = "entityManagerFactoryRefGeo")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }

    private final IRepRefGeoCRUD repositorioRefGeo;

    RepositorioRefGeo(IRepRefGeoCRUD repositorioRefGeo) {
        this.repositorioRefGeo = repositorioRefGeo;
    }

    @GetMapping("/refGeo")
    List<RefGeo> all() {
        return repositorioRefGeo.findAll();
    }

    @PostMapping("/refGeo")
    RefGeo novoRefGeo(@RequestBody RefGeo newRefGeo) {
        return repositorioRefGeo.save(newRefGeo);
    }

    @GetMapping("/refGeo/{id}")
    RefGeo one(@PathVariable Long id) {
        return repositorioRefGeo.findById(id)
                .orElseThrow(() -> new RefGeoNotFoundException(id));
    }

    @PutMapping("/refGeo/{id}")
    RefGeo substituirRefGeo(@RequestBody RefGeo novoRefGeo, @PathVariable Long id) {
        return repositorioRefGeo.findById(id).map(refGeo -> {
            refGeo.setNome(novoRefGeo.getNome());
            refGeo.setLatitude(novoRefGeo.getLatitude());
            refGeo.setLongitude(novoRefGeo.getLongitude());
            return repositorioRefGeo.save(refGeo);
        })
                .orElseGet(() -> {
                    novoRefGeo.setId(id);
                    return repositorioRefGeo.save(novoRefGeo);
                });

    }

    @DeleteMapping("/refGeo/{id}")
    void deleteRefGeo(@PathVariable Long id) {
        repositorioRefGeo.deleteById(id);
    }

}

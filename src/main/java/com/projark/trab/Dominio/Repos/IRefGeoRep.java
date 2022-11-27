package com.projark.trab.Dominio.Repos;

import java.util.*;
import com.projark.trab.Dominio.Entidades.RefGeo;

public interface IRefGeoRep {
    Optional<RefGeo> consultarPorId(long id);

    List<RefGeo> consultarTodasAsRefs();
}

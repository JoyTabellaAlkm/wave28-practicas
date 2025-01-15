package org.obras.service;

import org.obras.model.Obra;

import java.util.List;

public interface iObraService {
    List<Obra> findByAnio(String anio);

    List<Obra> findByAutorContaining(String autor);

    List<Obra> findTop5ByOrderByPaginasDesc();

}

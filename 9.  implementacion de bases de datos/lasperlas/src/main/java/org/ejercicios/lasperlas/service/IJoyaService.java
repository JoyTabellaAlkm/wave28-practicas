package org.ejercicios.lasperlas.service;

import org.ejercicios.lasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    List<Joya> getJoyas();
    Joya findJoya(Long id);
    Long saveJoya(Joya joya);
    void deleteJoya(Long id);
    Joya editJoya(Long id_modificar, Joya joya_modif);

}

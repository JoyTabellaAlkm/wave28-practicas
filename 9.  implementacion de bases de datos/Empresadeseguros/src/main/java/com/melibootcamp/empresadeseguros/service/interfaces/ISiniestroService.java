package com.melibootcamp.empresadeseguros.service.interfaces;


import com.melibootcamp.empresadeseguros.entity.Siniestro;
import java.time.LocalDate;
import java.util.List;

public interface ISiniestroService {
    public List<Siniestro> getSiniestros();
    public boolean saveSiniestro (Siniestro siniestro);
    public Siniestro getSiniestroById(long id);
    /*
    public boolean deleteSiniestro (long id);

    public boolean updateSiniestro(long id, Siniestro siniestro);

    */
}

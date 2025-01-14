package com.melibootcamp.empresadeseguros.service.interfaces;


import com.melibootcamp.empresadeseguros.dto.SiniestroDTO;
import com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO;
import com.melibootcamp.empresadeseguros.entity.Siniestro;
import java.time.LocalDate;
import java.util.List;

public interface ISiniestroService {
    public List<SiniestroDTO> getSiniestros();
    public boolean saveSiniestro (Siniestro siniestro);
    public Siniestro getSiniestroById(long id);

}

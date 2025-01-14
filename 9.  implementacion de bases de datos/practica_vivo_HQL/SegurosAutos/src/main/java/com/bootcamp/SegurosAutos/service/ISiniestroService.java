package com.bootcamp.SegurosAutos.service;

import com.bootcamp.SegurosAutos.dto.SiniestroDto;

import java.util.List;

public interface ISiniestroService {
    void post(Long vehiculoId, SiniestroDto dto);
    List<SiniestroDto> getAll();
}

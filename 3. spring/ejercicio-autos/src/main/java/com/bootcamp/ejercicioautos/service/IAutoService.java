package com.bootcamp.ejercicioautos.service;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;

import java.util.List;

public interface IAutoService {
    Long agregarAuto(PostAutoDto autoDto);
    List<ResponseAutoDto> obtenerAutos();
    ResponseAutoDto obtenerAutoPorId(Long id);
}

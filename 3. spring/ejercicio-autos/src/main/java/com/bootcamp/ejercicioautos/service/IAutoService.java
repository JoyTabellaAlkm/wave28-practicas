package com.bootcamp.ejercicioautos.service;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;

public interface IAutoService {
    Long agregarAuto(PostAutoDto autoDto);
}

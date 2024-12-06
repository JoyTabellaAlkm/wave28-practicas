package com.bootcamp.ejercicioautos.repository;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;

public interface IAutoRepository {
    Long agregarAuto(PostAutoDto autoDto);
}

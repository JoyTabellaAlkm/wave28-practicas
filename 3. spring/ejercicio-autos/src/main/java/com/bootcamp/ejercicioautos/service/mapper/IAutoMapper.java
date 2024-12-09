package com.bootcamp.ejercicioautos.service.mapper;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;
import com.bootcamp.ejercicioautos.model.Auto;

import java.util.List;

public interface IAutoMapper {
    Auto mapPostAutoDtoToAuto(PostAutoDto postAutoDto);

    List<ResponseAutoDto> mapListaAutoToResponseAutoDto(List<Auto> autos);
}

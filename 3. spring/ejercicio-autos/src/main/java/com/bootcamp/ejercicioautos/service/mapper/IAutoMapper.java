package com.bootcamp.ejercicioautos.service.mapper;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.request.PostServiceDto;
import com.bootcamp.ejercicioautos.model.Auto;

public interface IAutoMapper {
    Auto postDtoToAuto(PostAutoDto postAutoDto);
}

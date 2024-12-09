package com.bootcamp.ejercicioautos.service;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;
import com.bootcamp.ejercicioautos.repository.IAutoRepository;
import com.bootcamp.ejercicioautos.service.mapper.IAutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements IAutoService{
    @Autowired
    private IAutoRepository autoRepository;

    @Override
    public Long agregarAuto(PostAutoDto autoDto) {
        return autoRepository.agregarAuto(autoDto);
    }

    @Override
    public List<ResponseAutoDto> obtenerAutos() {
        return autoRepository.obtenerAutos();
    }
}

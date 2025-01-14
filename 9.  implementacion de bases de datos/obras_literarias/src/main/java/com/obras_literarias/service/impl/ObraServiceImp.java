package com.obras_literarias.service.impl;

import com.obras_literarias.DTO.ObraDto;
import com.obras_literarias.domain.Obra;
import com.obras_literarias.repository.IObraRepository;
import com.obras_literarias.service.IObraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraServiceImp implements IObraService {
    @Autowired
    private IObraRepository obraRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ObraDto createObra(ObraDto obra) {
        Obra newObra = modelMapper.map(obra, Obra.class);
        System.out.println(newObra);
        return modelMapper.map(obraRepository.save(newObra), ObraDto.class);
    }
}

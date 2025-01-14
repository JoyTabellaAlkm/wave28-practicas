package com.mercadolibre.lasperlas.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.lasperlas.dto.request.CreateJoyaDtoRequest;
import com.mercadolibre.lasperlas.dto.response.CreateJoyaDtoResponse;
import com.mercadolibre.lasperlas.dto.response.DeleteJoyaDtoResponse;
import com.mercadolibre.lasperlas.dto.response.FindJoyaDtoResponse;
import com.mercadolibre.lasperlas.model.Joya;
import com.mercadolibre.lasperlas.repository.IJoyaRepository;
import com.mercadolibre.lasperlas.service.IJoyaService;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    private IJoyaRepository joyaRepository;

    @Override
    public List<FindJoyaDtoResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return joyaRepository.findAll()
                .stream()
                .map(j -> modelMapper.map(j, FindJoyaDtoResponse.class))
                .toList();
    }

    @Override
    public FindJoyaDtoResponse findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Joya joya = joyaRepository.findById(id).orElseThrow();

        return modelMapper.map(joya, FindJoyaDtoResponse.class);
    }

    @Override
    public CreateJoyaDtoResponse save(CreateJoyaDtoRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Joya toSave = modelMapper.map(request, Joya.class);
        Joya saved = joyaRepository.save(toSave);

        return modelMapper.map(saved, CreateJoyaDtoResponse.class);
    }

    @Override
    public DeleteJoyaDtoResponse delete(Long id) {
        findById(id);
        joyaRepository.deleteById(id);
        return new DeleteJoyaDtoResponse("Joya eliminada correctamente");
    }

}

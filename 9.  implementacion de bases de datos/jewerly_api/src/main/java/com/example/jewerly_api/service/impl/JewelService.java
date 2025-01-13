package com.example.jewerly_api.service.impl;

import com.example.jewerly_api.dto.request.RequestJewelDto;
import com.example.jewerly_api.dto.response.ResponseCreateDto;
import com.example.jewerly_api.dto.response.ResponseDto;
import com.example.jewerly_api.dto.response.ResponseUpdateDto;
import com.example.jewerly_api.model.Jewel;
import com.example.jewerly_api.repository.JewelRepository;
import com.example.jewerly_api.service.IJewelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelService implements IJewelService {
    @Autowired
    private JewelRepository jewelRepository;

    @Override
    public ResponseCreateDto create(RequestJewelDto requestJewelDto) {
        ModelMapper modelMapper = new ModelMapper();
        Jewel jewel = jewelRepository.save(modelMapper.map(requestJewelDto, Jewel.class));
        return new ResponseCreateDto(jewel.getId(), "Se creo correctamente la Joya.");
    }

    @Override
    public List<Jewel> getAll() {
        return jewelRepository.findAllByCanSell(true);
    }

    @Override
    public ResponseDto delete(Long id) {
        Optional<Jewel> jewelOptional = jewelRepository.findByIdAndCanSell(id, true);
        if (jewelOptional.isEmpty()) {
            throw new RuntimeException("No se encontró la joya buscada.");
        }

        Jewel jewel = jewelOptional.get();
        jewel.setCanSell(false);

        jewelRepository.save(jewel);

        return new ResponseDto("Se elimino la joya correctamente.");
    }

    @Override
    public ResponseUpdateDto update(Long id, RequestJewelDto requestJewelDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Jewel> jewelOptional = jewelRepository.findByIdAndCanSell(id, true);
        if (jewelOptional.isEmpty()) {
            throw new RuntimeException("No se encontró la joya buscada.");
        }

        Jewel jewel = modelMapper.map(requestJewelDto, Jewel.class);
        jewel.setId(id);

        Jewel jewelUpdated = jewelRepository.save(jewel);

        return modelMapper.map(jewelUpdated, ResponseUpdateDto.class);
    }
}

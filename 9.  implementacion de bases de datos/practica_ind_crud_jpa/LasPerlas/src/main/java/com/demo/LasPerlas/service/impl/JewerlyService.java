package com.demo.LasPerlas.service.impl;

import com.demo.LasPerlas.dto.JewelDto;
import com.demo.LasPerlas.model.Jewel;
import com.demo.LasPerlas.repository.IJewelRepository;
import com.demo.LasPerlas.service.IJewerlyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {

    private final IJewelRepository jewelRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public JewerlyService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public Long post(JewelDto jewelDto) {
        Jewel jewel = new Jewel();
        modelMapper.map(jewelDto, jewel);
        return jewelRepository.save(jewel).getId();
    }

    @Override
    public List<JewelDto> getAll() {
        return jewelRepository.findAll()
                .stream()
                .filter(Jewel::isSaleOrNot)
                .map(jewel -> modelMapper.map(jewel, JewelDto.class))
                .toList();
    }

    @Override
    public void delete(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la joya con esa id."));
        jewel.setSaleOrNot(false);
        jewelRepository.save(jewel);
    }

    @Override
    public void update(Long id, JewelDto jewelDto) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la joya con esa id."));
        modelMapper.map(jewelDto, jewel);
        jewelRepository.save(jewel);
    }
}

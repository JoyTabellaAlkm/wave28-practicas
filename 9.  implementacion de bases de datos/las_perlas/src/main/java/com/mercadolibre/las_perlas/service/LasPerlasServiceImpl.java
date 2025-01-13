package com.mercadolibre.las_perlas.service;

import com.mercadolibre.las_perlas.dto.JoyaDTO;
import com.mercadolibre.las_perlas.entity.Joya;
import com.mercadolibre.las_perlas.exception.NotFoundException;
import com.mercadolibre.las_perlas.repository.ILasPerlasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LasPerlasServiceImpl implements ILasPerlasService{

    private ILasPerlasRepository iLasPerlasRepository;
    private ModelMapper modelMapper;

    public LasPerlasServiceImpl(ILasPerlasRepository iLasPerlasRepository) {
        this.iLasPerlasRepository = iLasPerlasRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<JoyaDTO> findAll() {
        List<Joya> joyas = this.iLasPerlasRepository.findAll();
        return joyas.stream().map(joya -> modelMapper.map(joya, JoyaDTO.class)).toList();
    }

    @Override
    public JoyaDTO findById(Long id) {
        Joya joya = this.iLasPerlasRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un anillo con el id solicitado"));
        return modelMapper.map(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO create(JoyaDTO joyaDTO) {
        joyaDTO.setVentaONo(true);
        Joya joya = modelMapper.map(joyaDTO, Joya.class);
        Joya joyaCreada =  this.iLasPerlasRepository.save(joya);
        joyaDTO.setId(joyaCreada.getId());

        return joyaDTO;
    }

    @Override
    public JoyaDTO update(Long id, JoyaDTO joyaDTO) {
        findById(id);
        joyaDTO.setId(id);

        Joya joyaActualizada = modelMapper.map(joyaDTO, Joya.class);
        this.iLasPerlasRepository.save(joyaActualizada);

        return joyaDTO;
    }

    @Override
    public JoyaDTO delete(Long id) {
        JoyaDTO joyaDto = findById(id);
        joyaDto.setVentaONo(false);

        Joya nuevaJoya = modelMapper.map(joyaDto, Joya.class);
        this.iLasPerlasRepository.save(nuevaJoya);

        return joyaDto;
    }
}

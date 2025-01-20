package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaCreateDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.exception.BadRequestException;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService{

    private final IPrendaRepository prendaRepository;

    ModelMapper modelMapper = new ModelMapper();

    public PrendaServiceImpl(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public PrendaDTO create(PrendaCreateDTO prendaDTO) {
        Prenda prenda = modelMapper.map(prendaDTO, Prenda.class);
        return modelMapper.map(prendaRepository.save(prenda), PrendaDTO.class);
    }

    @Override
    public List<PrendaDTO> getAll(String name) {
        List<Prenda> prendas;
        if (name != null){
            prendas = prendaRepository.findAllByNombreIgnoreCaseContaining(name);
        } else {
            prendas = prendaRepository.findAll();
        }
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class)).toList();
    }

    @Override
    public PrendaDTO getPrendaByCode(Long code) {
        Prenda prenda = prendaRepository.findById(code).orElseThrow(() -> new NotFoundException("prenda", code));
        return modelMapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public PrendaDTO updatePrendaByCode(Long code, PrendaCreateDTO prendaDTO) {
        Prenda prenda = prendaRepository.findById(code).orElseThrow(() -> new NotFoundException("prenda", code));
        Prenda prendaAGuardar = modelMapper.map(prendaDTO, Prenda.class);
        prendaAGuardar.setCodigo(prenda.getCodigo());
        return modelMapper.map(prendaRepository.save(prendaAGuardar), PrendaDTO.class);
    }

    @Override
    public void deletePrenda(Long code) {
        prendaRepository.deleteById(code);
    }

    public List<PrendaDTO> findByTalle(String talle){
        return prendaRepository.findByTalle(talle).stream()
                .map(prendas -> modelMapper.map(prendas, PrendaDTO.class))
                .toList();
    }

//    @Override
//    public List<PrendaDTO> findAllByNombreIgnoreCaseContaining(String nombre) {
//        return prendaRepository.findAllByNombreIgnoreCaseContaining(nombre).stream()
//                .map(prendas -> modelMapper.map(prendas, PrendaDTO.class))
//                .toList();
//    }
}

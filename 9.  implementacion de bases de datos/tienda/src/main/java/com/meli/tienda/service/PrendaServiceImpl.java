package com.meli.tienda.service;

import com.meli.tienda.dto.MessageDto;
import com.meli.tienda.dto.PrendaDto;
import com.meli.tienda.model.Prenda;
import com.meli.tienda.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService {

    @Autowired
    PrendaRepository prendaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PrendaDto crearNuevaPrenda(PrendaDto prendaDto) {
        Prenda nuevaPrenda = prendaRepository.save(modelMapper.map(prendaDto, Prenda.class));
        return modelMapper.map(nuevaPrenda, PrendaDto.class);
    }

    @Override
    public List<PrendaDto> traerTodasPrendas() {
        return prendaRepository.findAll().stream().map( p -> modelMapper.map(p, PrendaDto.class)).toList();
    }

    @Override
    public PrendaDto traerPrendaPorId(Long id) {
        return modelMapper.map(prendaRepository.findById(id), PrendaDto.class);
    }

    @Override
    public PrendaDto actualizarPorId(Long id, PrendaDto prendaDto) {
        Prenda prendaAActualizar = prendaRepository.findById(id).get();
        prendaAActualizar.setNombre(prendaDto.getNombre());
        prendaAActualizar.setMarca(prendaDto.getMarca());
        prendaAActualizar.setTipo(prendaDto.getTipo());
        prendaAActualizar.setTalle(prendaDto.getTalle());
        prendaAActualizar.setCantidad(prendaDto.getCantidad());
        prendaAActualizar.setColor(prendaDto.getColor());
        prendaAActualizar.setPrecioVenta(prendaDto.getPrecioVenta());
        return modelMapper.map(prendaRepository.save(prendaAActualizar), PrendaDto.class);
    }

    @Override
    public MessageDto eliminarPorId(Long id) {
        prendaRepository.deleteById(id);
        MessageDto messageDto = new MessageDto();
        messageDto.setMensaje("Se eliminio correctamente");
        return messageDto;
    }

    @Override
    public List<PrendaDto> traerPrendaPorTalle(int size) {
         return prendaRepository.findPrendaByTalle(size)
                 .stream().map(p -> modelMapper.map( p , PrendaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> traerPrendasPorNombre(String nombre) {
        return prendaRepository.findByNombreContainingIgnoreCase(nombre)
                .stream().map(p -> modelMapper.map( p , PrendaDto.class)).toList();
    }
}


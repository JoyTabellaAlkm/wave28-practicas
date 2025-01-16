package com.melibootcamp.showroom.service;

import com.melibootcamp.showroom.dto.PrendaDto;
import com.melibootcamp.showroom.dto.VentaDto;
import com.melibootcamp.showroom.entity.Venta;
import com.melibootcamp.showroom.repository.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VentaServiceImpl implements VentaService{
    
    private final VentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaServiceImpl(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<VentaDto> getVentas() {
        List<VentaDto> toReturn = ventaRepository.findAll().stream()
                .map(x -> modelMapper.map(x, VentaDto.class))
                .toList();
        return toReturn;
    }

    @Override
    public VentaDto getVentaById(long id) {
        VentaDto toReturn = modelMapper.map(
                ventaRepository.findById(id).orElse(null), VentaDto.class);
        return toReturn;
    }


    @Override
    public boolean saveVenta(VentaDto venta) {
        Venta toSave = modelMapper.map(venta, Venta.class);
        ventaRepository.save(toSave);
        return true;
    }

    @Override
    public boolean deleteVenta(long id) {
        try{
            ventaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @Override
    public boolean updateVenta(long id, VentaDto venta) {

        if (!ventaRepository.existsById(id)){
            return false;
        }

        venta.setId(id);
        Venta toUpdate = modelMapper.map(venta, Venta.class);
        ventaRepository.save(toUpdate);
        return true;
    }
    
    
}

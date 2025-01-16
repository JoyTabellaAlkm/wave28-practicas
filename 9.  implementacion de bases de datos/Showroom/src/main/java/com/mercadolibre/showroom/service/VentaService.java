package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.dto.VentaDto;
import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.entity.Venta;
import com.mercadolibre.showroom.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    private final IVentaRepository ventaRepository;
    ModelMapper modelMapper = new ModelMapper();

    public VentaService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Long createVenta(VentaDto ventaDto) {
        Venta v = modelMapper.map(ventaDto, Venta.class);
        v.setPrendas(ventaDto.getPrendas().stream().map(prendaDto -> modelMapper.map(prendaDto, Prenda.class)).toList());
        ventaRepository.save(modelMapper.map(ventaDto, Venta.class));
        return v.getNumero();
    }

    @Override
    public List<VentaDto> getVentas() {
        return ventaRepository.findAll().stream().map(venta -> modelMapper.map(venta, VentaDto.class)).toList();
    }

    @Override
    public VentaDto getVentaByNumber(Long number) {
        return ventaRepository.findById(number).map(venta -> modelMapper.map(venta, VentaDto.class)).orElse(null);
    }

    @Override
    public Long updateVenta(Long number, VentaDto venta) {
        return null;
    }

    @Override
    public Long deleteVenta(Long number) {
        if(ventaRepository.existsById(number)) {
            ventaRepository.deleteById(number);
            return number;
        }
        return null;
    }

    @Override
    public List<VentaDto> getVentasByDate(LocalDate date) {
        return ventaRepository.findByFecha(date).stream().map(venta -> modelMapper.map(venta, VentaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> getClothesFromVenta(Long number) {
        return ventaRepository.findByClothesNumber(number).stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }
}

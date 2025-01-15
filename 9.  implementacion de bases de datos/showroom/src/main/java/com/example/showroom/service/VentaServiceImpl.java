package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.dto.VentaWithAttributesDto;
import com.example.showroom.model.Prenda;
import com.example.showroom.model.Venta;
import com.example.showroom.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService{

    private final IVentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaServiceImpl(IVentaRepository ventaRepository, ModelMapper modelMapper){
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VentaWithAttributesDto createVenta(VentaDto ventaDto) {
        Venta toSave = modelMapper.map(ventaDto, Venta.class);
        double totalVenta = toSave.getPrendas()
                .stream()
                .mapToDouble(p -> p.getCantidad() * p.getPrecioVenta())
                .sum();
        toSave.setTotal(BigDecimal.valueOf(totalVenta));

        Venta saved = ventaRepository.save(toSave);
        return getVentaByNumber(saved.getNumero());
    }

    @Override
    public List<VentaWithAttributesDto> getAllVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream()
                .map(v -> modelMapper.map(v, VentaWithAttributesDto.class))
                .toList();
    }

    @Override
    public VentaWithAttributesDto getVentaByNumber(Integer number) {
        Optional<Venta> venta = ventaRepository.findById(number);
        if(venta.isEmpty()) {
            throw new NoSuchElementException();
        }

        return modelMapper.map(venta, VentaWithAttributesDto.class);
    }

    @Override
    public VentaWithAttributesDto updateVenta(VentaDto venta, Integer numero) {
        getVentaByNumber(numero);

        Venta toUpdate = modelMapper.map(venta, Venta.class);
        toUpdate.setNumero(numero);
        return modelMapper.map(ventaRepository.save(toUpdate), VentaWithAttributesDto.class);
    }

    @Override
    public MessageDto deleteVenta(Integer numero) {
        getVentaByNumber(numero);
        ventaRepository.deleteById(numero);
        return new MessageDto("La venta con el numero " + numero + " ha sido eliminada correctamente");
    }

    @Override
    public List<PrendaDto> getPrendasByVentaNumber(Integer numero){
        List<Prenda> prendas = ventaRepository.findPrendasByNumero(numero);
        return prendas.stream()
                .map(p -> modelMapper.map(p, PrendaDto.class))
                .toList();
    }

    @Override
    public List<VentaDto> getVentasByDate(LocalDateTime date){
        List<Venta> ventas = ventaRepository.findVentasByFechaAfter(date);
        return ventas.stream().map(v -> modelMapper.map(v, VentaDto.class)).toList();
    }

}

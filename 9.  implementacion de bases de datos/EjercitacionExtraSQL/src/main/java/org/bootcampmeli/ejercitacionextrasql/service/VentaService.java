package org.bootcampmeli.ejercitacionextrasql.service;

import org.bootcampmeli.ejercitacionextrasql.dto.VentaCreateRequestDTO;
import org.bootcampmeli.ejercitacionextrasql.dto.VentaCreateResponseDTO;
import org.bootcampmeli.ejercitacionextrasql.model.Prenda;
import org.bootcampmeli.ejercitacionextrasql.model.Venta;
import org.bootcampmeli.ejercitacionextrasql.repository.PrendaRepository;
import org.bootcampmeli.ejercitacionextrasql.repository.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private PrendaRepository prendaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VentaCreateResponseDTO addVenta(VentaCreateRequestDTO dto)  {
        Venta model = modelMapper.map(dto, Venta.class);
        List<Prenda> prendas = new ArrayList<>();
        for (Long prendaID : dto.getPrendasIDs()) {
            Prenda prendaEncontrada = prendaRepository.findByCodigo(prendaID);
            if(prendaEncontrada == null){
                throw new RuntimeException("Prenda no encontrada");
            }
            prendas.add(prendaEncontrada);
        }
        model.setPrendas(prendas);
        return modelMapper.map(this.ventaRepository.save(model), VentaCreateResponseDTO.class);

    }
}

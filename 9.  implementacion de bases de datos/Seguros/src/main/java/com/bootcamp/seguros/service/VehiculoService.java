package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalResponseDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteYMarcaDTO;
import com.bootcamp.seguros.entity.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    ModelMapper modelMapper = new ModelMapper();

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculoRepository
                .findAll()
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    @Override
    public List<VehiculoPatenteYMarcaDTO> findByPatentesyMarcasSortedByAnio() {
        return vehiculoRepository.findAllOrderByAnioDeFabricacion()
                .stream()
                .map(vehiculo -> new VehiculoPatenteYMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }

    public List<String> findByPatenteFilterByFourRuedasAndCurrentAnio() {
        return vehiculoRepository
                .findallFilterByFourRuedasAndAnioDeFabricacion(LocalDate.now().getYear())
                .stream()
                .map(Vehiculo::getPatente)
                .toList();
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDTO> findBySiniestroConPerdidaMayorA10000() {
        return vehiculoRepository
                .findBySiniestroConPerdidaMayorA10000()
                .stream()
                .map(v -> modelMapper.map(v, VehiculoPatenteMarcaModeloDTO.class))
                //.map(vehiculo -> new VehiculoPatenteMarcaModeloDTO(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()))
                .toList();
    }

    @Override
    public VehiculoPatenteMarcaModeloTotalResponseDTO findBySiniestroConPerdidaMayorA10000AndPerdidaTotal() {
        List<VehiculoPatenteMarcaModeloTotalDTO> vs =  vehiculoRepository
                .findBySiniestroConPerdidaMayorA10000AndPerdidaTotal()
                .stream()
                .map(v -> modelMapper.map(v, VehiculoPatenteMarcaModeloTotalDTO.class))
                .toList();

        VehiculoPatenteMarcaModeloTotalResponseDTO response = new VehiculoPatenteMarcaModeloTotalResponseDTO();
        double total = 0.0;
        for (VehiculoPatenteMarcaModeloTotalDTO v : vs) {
            VehiculoPatenteMarcaModeloDTO vvs = modelMapper.map(v, VehiculoPatenteMarcaModeloDTO.class);
            response.getVehiculos().add(vvs);
            total = v.getSumaPerdidaEconomica();
        }
        // Uso esto asi porque lo traigo en la query, pero se deberia usar el sum de get perdida economica sola
        response.setTotal(total);
        return response;
    }
}

package com.bootcamp.SegurosAutos.service.impl;

import com.bootcamp.SegurosAutos.dto.PatenteMarcaDto;
import com.bootcamp.SegurosAutos.dto.PatentesDto;
import com.bootcamp.SegurosAutos.dto.VehiculoDto;
import com.bootcamp.SegurosAutos.entity.Vehiculo;
import com.bootcamp.SegurosAutos.repository.IVehiculoRepository;
import com.bootcamp.SegurosAutos.repository.projection.PatenteMarcaProjection;
import com.bootcamp.SegurosAutos.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void post(VehiculoDto dto) {
        Vehiculo vehiculo = new Vehiculo();
        modelMapper.map(dto, vehiculo);
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<VehiculoDto> getAll() {
        return vehiculoRepository.findAll().stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class))
                .toList();
    }

    @Override
    public PatentesDto patentes() {
        return new PatentesDto(vehiculoRepository.obtenerPatentes());
    }

    @Override
    public List<PatenteMarcaDto> patentesMarcasOrdenadasPorFechaFabricacion() {
        List<PatenteMarcaProjection> proyecciones = vehiculoRepository.obtenerPatentesYMarcasOrdenadosPorFabricacion();
        return proyecciones.stream()
                .map(proyeccion -> modelMapper.map(proyeccion, PatenteMarcaDto.class))
                .toList();
    }

    @Override
    public List<PatenteMarcaDto> patentesMarcasMasDeCuatroRuedasFabricadosEsteAnio() {
        List<PatenteMarcaProjection> proyecciones = vehiculoRepository.obtenerPatentesMarcasDeAutosMasDeCuatroRuedasFabricadosEsteAnio(LocalDate.now().getYear());
        return proyecciones.stream()
                .map(proyeccion -> modelMapper.map(proyeccion, PatenteMarcaDto.class))
                .toList();
    }
}

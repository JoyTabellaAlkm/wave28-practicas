package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoUsadoDTO;
import com.bootcamp.concesionaria.exception.NotFoundException;
import com.bootcamp.concesionaria.mapper.VehiculoMapper;
import com.bootcamp.concesionaria.model.Vehiculo;
import com.bootcamp.concesionaria.repository.VehiculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoDao vehiculoDao;

    @Override
    public List<VehiculoDTO> getBetweeenPrice(Double since, Double to) {
        return vehiculoDao.findAll().stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .map(VehiculoMapper::toVehiculoDTO)
                .toList();
    }

    @Override
    public VehiculoDTO getById(Long id) throws NotFoundException {
        Vehiculo v = vehiculoDao.findById(id).orElseThrow(() -> new NotFoundException("Vehiculo"));
        return VehiculoMapper.toVehiculoDTO(v);
    }

    @Override
    public List<VehiculoDTO> getManufacturedBetween(LocalDate since, LocalDate to) {
        return vehiculoDao.findAll().stream()
                .filter(v -> v.getManufacturingDate().compareTo(since) >= 0)
                .filter(v -> v.getManufacturingDate().compareTo(to) <= 0)
                .map(VehiculoMapper::toVehiculoDTO)
                .toList();
    }

    @Override
    public List<VehiculoUsadoDTO> getUsados() {
        return vehiculoDao.findUsados().stream()
                .map(VehiculoMapper::toVehiculoUsadoDTO)
                .toList();
    }

    @Override
    public void create(VehiculoDTO vehiculo) {
        Vehiculo v = VehiculoMapper.from(vehiculo);
        //TODO: agregar ids a los Service
        v.setId(vehiculoDao.getNextId());
        vehiculoDao.save(v);
    }
}

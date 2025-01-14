package com.mercadolibre.autoinsurance.service.impl;

import com.mercadolibre.autoinsurance.dto.request.AccidentRequestDto;
import com.mercadolibre.autoinsurance.dto.response.AccidentResponseDto;
import com.mercadolibre.autoinsurance.entity.Accident;
import com.mercadolibre.autoinsurance.entity.Vehicle;
import com.mercadolibre.autoinsurance.repository.IAccidentRepository;
import com.mercadolibre.autoinsurance.repository.IVehicleRepository;
import com.mercadolibre.autoinsurance.service.IAccidentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mercadolibre.autoinsurance.utils.Mapper.mapper;

@Service
public class AccidentService implements IAccidentService {
    private final IAccidentRepository accidentRepository;
    private final IVehicleRepository vehicleRepository;

    public AccidentService(IAccidentRepository accidentRepository, IVehicleRepository vehicleRepository) {
        this.accidentRepository = accidentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public AccidentResponseDto save(AccidentRequestDto accidentRequestDto) {

        Vehicle vehicle = vehicleRepository.findById(accidentRequestDto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Accident accident = new Accident();
        accident.setDateOfAccident(accidentRequestDto.getDateOfAccident());
        accident.setEconomicLoss(accidentRequestDto.getEconomicLoss());
        accident.setVehicle(vehicle);

        Accident savedAccident = accidentRepository.save(accident);

        return mapper.map(savedAccident, AccidentResponseDto.class);
    }

    @Override
    public List<AccidentResponseDto> findAll() {
        return accidentRepository.findAll().stream()
                .map(accident -> mapper.map(accident, AccidentResponseDto.class))
                .toList();
    }
}

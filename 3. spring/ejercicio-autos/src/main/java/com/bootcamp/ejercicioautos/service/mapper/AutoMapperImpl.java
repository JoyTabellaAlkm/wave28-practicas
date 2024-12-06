package com.bootcamp.ejercicioautos.service.mapper;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.model.Auto;
import com.bootcamp.ejercicioautos.model.Service;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AutoMapperImpl implements IAutoMapper {
    @Override
    public Auto postDtoToAuto(PostAutoDto postAutoDto) {
        return new Auto(
                postAutoDto.getBrand(),
                postAutoDto.getModel(),
                postAutoDto.getManufacturingDate(),
                postAutoDto.getNumberOfKilometers(),
                postAutoDto.getDoors(),
                postAutoDto.getPrice(),
                postAutoDto.getCurrency(),
                postAutoDto.getServices().
                        stream().
                        map(serviceDto -> new Service(serviceDto.getDate(), serviceDto.getKilometers(), serviceDto.getDescriptions())).collect(Collectors.toList()),
                postAutoDto.getCountOfOwners()
        );
    }
}

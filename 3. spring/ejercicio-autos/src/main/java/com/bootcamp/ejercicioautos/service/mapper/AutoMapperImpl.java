package com.bootcamp.ejercicioautos.service.mapper;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;
import com.bootcamp.ejercicioautos.model.Auto;
import com.bootcamp.ejercicioautos.model.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutoMapperImpl implements IAutoMapper {
    @Override
    public Auto mapPostAutoDtoToAuto(PostAutoDto postAutoDto) {
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

    @Override
    public List<ResponseAutoDto> mapListaAutoToResponseAutoDto(List<Auto> autos) {
        return autos.stream().map(a -> new ResponseAutoDto(
                a.getBrand(),
                a.getModel(),
                a.getManufacturingDate(),
                a.getNumberOfKilometers(),
                a.getDoors(),
                a.getPrice(),
                a.getCurrency(),
                a.getCountOfOwners()
        )).collect(Collectors.toList());
    }
}

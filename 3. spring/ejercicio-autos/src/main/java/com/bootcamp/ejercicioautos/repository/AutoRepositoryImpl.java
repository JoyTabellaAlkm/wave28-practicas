package com.bootcamp.ejercicioautos.repository;

import com.bootcamp.ejercicioautos.dto.request.PostAutoDto;
import com.bootcamp.ejercicioautos.dto.response.ResponseAutoDto;
import com.bootcamp.ejercicioautos.exception.AutoNotFoundException;
import com.bootcamp.ejercicioautos.model.Auto;
import com.bootcamp.ejercicioautos.model.Service;
import com.bootcamp.ejercicioautos.service.mapper.IAutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepositoryImpl implements IAutoRepository{
    private List<Auto> autos;
    @Autowired
    private IAutoMapper autoMapper;

    public AutoRepositoryImpl() {
        this.autos = new ArrayList<>(List.of(
                new Auto("Chevrolet", "Corsa", "2020-11-20", "115000", "5", "90000", "AR", new ArrayList<>(List.of(new Service("2003-5-20", "60000", "Change air filters"))),"2"),
                new Auto("Ford", "Focus", "2020-11-20", "115000", "5", "90000", "AR", new ArrayList<>(List.of(new Service("2003-5-20", "60000", "Change air filters"))),"2"),
                new Auto("Toyota", "Corolla", "2020-11-20", "115000", "5", "90000", "AR", new ArrayList<>(List.of(new Service("2003-5-20", "60000", "Change air filters"))),"2")
        ));
    }

    @Override
    public Long agregarAuto(PostAutoDto autoDto) {
        Auto autoAgregado = autoMapper.mapPostAutoDtoToAuto(autoDto);
        autos.add(autoAgregado);

        return autoAgregado.getId();
    }

    @Override
    public List<ResponseAutoDto> obtenerAutos() {
        return autoMapper.mapListaAutoToResponseAutoDto(autos);
    }

    @Override
    public ResponseAutoDto obtenerAutoPorId(Long id) {
        Optional<Auto> autoObtenido = autos.stream().filter(a -> a.getId().equals(id)).findFirst();

        if (autoObtenido.isEmpty()) {
            throw new AutoNotFoundException();
        }

        return autoMapper.mapAutoToResponseAutoDto(autoObtenido.get());
    }
}

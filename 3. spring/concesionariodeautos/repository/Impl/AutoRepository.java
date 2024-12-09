package com.mercadolibre.concesionariodeautos.repository.Impl;

import com.mercadolibre.concesionariodeautos.model.Auto;
import com.mercadolibre.concesionariodeautos.repository.IAutoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepository implements IAutoRepository {

    private static final List<Auto> autosList = new ArrayList<>();
    private static Integer CONTADOR_AUTOS = 0;

    @Override
    public List<Auto> readAll() {
        return autosList;
    }

    @Override
    public Optional<Auto> readById(Integer id) {
        return autosList.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public Auto create(Auto obj) {
        CONTADOR_AUTOS++;
        obj.setId(CONTADOR_AUTOS);
        autosList.add(obj);
        return obj;
    }

    @Override
    public Auto update(Auto obj) {
        return null;
    }

    @Override
    public Auto deleteById(Integer id) {
        return null;
    }

    @Override
    public List<Auto> readByDate(Integer since, Integer to) {
        return autosList.stream()
                .filter(auto -> auto.getManufacturingDate().getYear() >= since
                        && auto.getManufacturingDate().getYear() <= to).toList();
    }
}

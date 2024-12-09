package com.mercadolibre.concesionariodeautos.repository.Impl;

import com.mercadolibre.concesionariodeautos.model.Service;
import com.mercadolibre.concesionariodeautos.repository.IServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ServiceRepository implements IServiceRepository {

    private static final List<Service> serviceList = new ArrayList<>();
    private static Integer CONTADOR_SERVICES = 0;

    @Override
    public List<Service> readAll() {
        return serviceList;
    }

    @Override
    public Optional<Service> readById(Integer id) {
        return serviceList.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public Service create(Service obj) {
        CONTADOR_SERVICES++;
        obj.setId(CONTADOR_SERVICES);
        serviceList.add(obj);
        return obj;
    }

    @Override
    public Service update(Service obj) {
        return null;
    }

    @Override
    public Service deleteById(Integer id) {
        return null;
    }
}

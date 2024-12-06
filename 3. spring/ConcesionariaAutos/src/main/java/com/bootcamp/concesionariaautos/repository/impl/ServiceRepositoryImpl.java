package com.bootcamp.concesionariaautos.repository.impl;

import com.bootcamp.concesionariaautos.model.Service;
import com.bootcamp.concesionariaautos.model.Vehicle;
import com.bootcamp.concesionariaautos.repository.ServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {

    private static long CONTADOR_SERVICIOS = 0;
    private static final List<Service> serviceList = new ArrayList<>();

    @Override
    public Service deleteById(Long id) {
        Optional<Service> optionalService = findById(id);
        if(optionalService.isPresent()) {
            serviceList.remove(optionalService.get());
            return optionalService.get();
        }
        return null;
    }

    @Override
    public List<Service> findAll() {
        return serviceList;
    }

    @Override
    public Optional<Service> findById(Long id) {
        return serviceList.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Service save(Service obj) {
        obj.setId(CONTADOR_SERVICIOS);
        CONTADOR_SERVICIOS++;
        serviceList.add(obj);
        return obj;
    }

    @Override
    public Service update(Service obj) {
        Optional<Service> optionalservice = findById(obj.getId());
        if(optionalservice.isPresent()) {
            int pos = serviceList.indexOf(optionalservice.get());
            serviceList.set(pos, obj);
            return obj;
        }
        return null;
    }
}

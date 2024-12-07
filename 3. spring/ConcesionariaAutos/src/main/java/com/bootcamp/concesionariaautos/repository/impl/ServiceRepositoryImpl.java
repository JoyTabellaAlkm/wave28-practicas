package com.bootcamp.concesionariaautos.repository.impl;

import com.bootcamp.concesionariaautos.model.ServiceEntity;
import com.bootcamp.concesionariaautos.repository.ServiceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {

    private static long CONTADOR_SERVICIOS = 2;
    private static final List<ServiceEntity> serviceList = new ArrayList<>() {{
        add(new ServiceEntity(
                1L,
                1L,
                LocalDate.of(2024, 12, 4),
                104000.0,
                "Se arregló una pata del motor"
        ));
        add(new ServiceEntity(
                2L,
                1L,
                LocalDate.of(2024, 10, 21),
                104000.0,
                "Se cambió el foco de giro delantero izquierdo"
        ));
    }};

    @Override
    public ServiceEntity deleteById(Long id) {
        Optional<ServiceEntity> optionalService = findById(id);
        if(optionalService.isPresent()) {
            serviceList.remove(optionalService.get());
            return optionalService.get();
        }
        return null;
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceList;
    }

    @Override
    public Optional<ServiceEntity> findById(Long id) {
        return serviceList.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public ServiceEntity save(ServiceEntity obj) {
        CONTADOR_SERVICIOS++;
        obj.setId(CONTADOR_SERVICIOS);
        serviceList.add(obj);
        return obj;
    }

    @Override
    public ServiceEntity update(ServiceEntity obj) {
        Optional<ServiceEntity> optionalservice = findById(obj.getId());
        if(optionalservice.isPresent()) {
            int pos = serviceList.indexOf(optionalservice.get());
            serviceList.set(pos, obj);
            return obj;
        }
        return null;
    }
}

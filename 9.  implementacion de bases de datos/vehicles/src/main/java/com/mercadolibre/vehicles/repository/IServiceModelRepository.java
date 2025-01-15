package com.mercadolibre.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.vehicles.model.ServiceModel;

public interface IServiceModelRepository extends JpaRepository<ServiceModel, Integer> {

}

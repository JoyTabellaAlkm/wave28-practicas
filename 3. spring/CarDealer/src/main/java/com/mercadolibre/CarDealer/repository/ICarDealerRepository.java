package com.mercadolibre.CarDealer.repository;

import com.mercadolibre.CarDealer.dto.CarDTO;
import com.mercadolibre.CarDealer.dto.ServiceDTO;
import com.mercadolibre.CarDealer.entity.CarEntity;
import com.mercadolibre.CarDealer.entity.ServiceEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ICarDealerRepository {

    public void addCar(CarEntity car);
    public List<CarEntity> listWithOutServices();
    public List<CarEntity> findByDate(Date since, Date to);
    public List<CarEntity> findByPrice(int since,int to);
    public List<CarEntity> findById(int id);
}

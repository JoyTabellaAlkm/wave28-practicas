package com.mercadolibre.CarDealer.service;

import com.mercadolibre.CarDealer.dto.CarDTO;
import com.mercadolibre.CarDealer.dto.ServiceDTO;
import org.springframework.core.GenericTypeResolver;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICarDealearService {
    public void addCar(CarDTO car);
    public List<CarDTO> listWithOutServices();
    public List<CarDTO> findByDate(Date since,Date to);
    public List<CarDTO> findByPrice(int since,int to);
    public List<CarDTO> findById(int id);

}

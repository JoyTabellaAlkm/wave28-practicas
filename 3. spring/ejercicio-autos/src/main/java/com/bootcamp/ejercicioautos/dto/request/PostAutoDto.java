package com.bootcamp.ejercicioautos.dto.request;

import com.bootcamp.ejercicioautos.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class PostAutoDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<PostServiceDto> services;
    private String countOfOwners;
}

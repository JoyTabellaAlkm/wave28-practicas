package com.example.consecionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private LocalDate date;
    private double kilometers;
    private String descriptions;
}

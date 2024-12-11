package com.example.concecionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}

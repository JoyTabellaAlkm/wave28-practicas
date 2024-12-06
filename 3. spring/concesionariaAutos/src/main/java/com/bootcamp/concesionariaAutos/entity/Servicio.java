package com.bootcamp.concesionariaAutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    int id;
    Local date;
    double kilometers;
    String descriptions;
}

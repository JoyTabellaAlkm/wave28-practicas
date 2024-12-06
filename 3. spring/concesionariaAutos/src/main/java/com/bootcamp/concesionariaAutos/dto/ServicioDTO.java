package com.bootcamp.concesionariaAutos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {
    Local date;
    double kilometers;
    String descriptions;
}

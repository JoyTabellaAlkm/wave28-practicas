package org.bootcampmeli.ejercicioconcesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ServicioDTO {
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}

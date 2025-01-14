package org.bootcampmeli.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class SiniestroDto {
    private Long id;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    private Long vehiculoId;
}

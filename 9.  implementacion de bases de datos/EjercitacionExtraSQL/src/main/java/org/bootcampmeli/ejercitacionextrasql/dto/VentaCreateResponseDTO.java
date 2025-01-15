package org.bootcampmeli.ejercitacionextrasql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaCreateResponseDTO {
    private long id;

    private LocalDate fecha;

    private double total;

    @JsonProperty("medio_de_pago")
    private String medioDePago;

    private List<PrendaDto> prendas;

}

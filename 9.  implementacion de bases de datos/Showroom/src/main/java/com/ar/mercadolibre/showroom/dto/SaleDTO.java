package com.ar.mercadolibre.showroom.dto;

import com.ar.mercadolibre.showroom.entity.Clothe;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {

    private int numero;
    @JsonFormat(pattern = "dd-MM-yyyy")  // Para serialización (salida del DTO)
    private LocalDate fecha;
    private double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    private List<ClotheDTO> listaDePrendas;

}

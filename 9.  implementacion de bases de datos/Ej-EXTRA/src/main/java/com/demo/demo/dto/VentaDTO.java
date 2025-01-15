package com.demo.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VentaDTO {
    private Long numero;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    private List<PrendaDTO> prendas;
}

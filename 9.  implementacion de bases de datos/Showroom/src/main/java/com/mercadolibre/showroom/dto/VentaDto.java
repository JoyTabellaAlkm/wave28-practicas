package com.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.showroom.entity.Prenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {
    private LocalDate fecha;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    private List<Prenda> prendas;

    public Double getTotal(){
        return prendas.stream().mapToDouble(Prenda::getPrecioVenta).sum();
    }
}

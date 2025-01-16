package com.example.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaWithAttributesDto extends VentaDto {

    private Integer numero;
    private LocalDateTime fecha;
    private BigDecimal total;

}

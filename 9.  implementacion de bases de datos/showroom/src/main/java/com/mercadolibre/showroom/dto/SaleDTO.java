package com.mercadolibre.showroom.dto;

import com.mercadolibre.showroom.entity.Clothe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long id;
    private Integer number;
    private LocalDate date;
    private Float total;
    private String paymentMethod;
    private List<ClotheDTO> clothes;
}

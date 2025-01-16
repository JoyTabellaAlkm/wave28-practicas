package com.mercadolibre.ejercicioextrashowroom.dto.response;

import com.mercadolibre.ejercicioextrashowroom.entity.Clothes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    Long id;

    LocalDate date;

    Double total;

    String paymentType;

    Set<ClothesDTO> items;


}

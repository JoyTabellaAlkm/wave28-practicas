package com.mercadolibre.ejercicioextrashowroom.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.ejercicioextrashowroom.dto.response.ClothesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleDTO {

    @JsonProperty("payment_type")
    String paymentType;

    Set<ClothesDTO> items = new HashSet<>();

}

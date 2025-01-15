package com.mercadolibre.showroom.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDTO {

    BigDecimal total;
    private String paymentMethod;
    private List<SaleClothingDTO> clothings;

}

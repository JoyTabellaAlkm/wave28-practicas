package com.mercadolibre.showroom.dto.responses;

import com.mercadolibre.showroom.dto.ClothingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleClothingDTO {

    private Integer quantity;
    private ClothingDTO clothing;
}

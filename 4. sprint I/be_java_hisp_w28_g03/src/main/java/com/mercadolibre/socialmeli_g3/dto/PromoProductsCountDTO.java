package com.mercadolibre.socialmeli_g3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoProductsCountDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;
}

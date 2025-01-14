package com.ar.mercadolibre.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateMessageDTO {
    private JewelryDTO jewelryDTO;
    private String message;
}

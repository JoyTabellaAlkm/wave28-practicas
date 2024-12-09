package com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDto {
    private Integer id;
    private String link;
    private Integer counter;
}

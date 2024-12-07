package com.mercadolibre.athletes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportDTO {
    private String name;
    private Integer level;
}

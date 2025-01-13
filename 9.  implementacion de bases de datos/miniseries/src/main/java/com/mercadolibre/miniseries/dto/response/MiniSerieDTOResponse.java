package com.mercadolibre.miniseries.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieDTOResponse {
    Long id;
    String name;
    Double rating;
    int amount_of_awards;
}

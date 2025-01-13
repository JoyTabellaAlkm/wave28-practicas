package com.mercadolibre.miniseries.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieDTO {
    String name;
    Double rating;
    int amount_of_awards;
}

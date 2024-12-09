package com.mercadolibre.linktracker.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkMetricsResponseDTO {
    private long linkId;
    private String originalLink;
    private int counter;
}

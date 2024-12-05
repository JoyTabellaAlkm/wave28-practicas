package com.example.ejerciciolinks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkMetricDTO {
    private String url;
    private Integer contadorEstadistica;

}

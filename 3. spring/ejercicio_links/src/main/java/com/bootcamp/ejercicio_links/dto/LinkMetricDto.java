package com.bootcamp.ejercicio_links.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkMetricDto {
    private Integer contador;
    private String linkUrl;
}

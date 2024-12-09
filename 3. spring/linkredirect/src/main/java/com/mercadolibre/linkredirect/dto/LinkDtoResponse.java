package com.mercadolibre.linkredirect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDtoResponse {
    private Long id;
    private String link;
    private Integer viewCount;
}
